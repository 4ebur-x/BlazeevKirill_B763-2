import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static final String CLIENTS_FILE = "clients.txt";

    public static void main(String[] args) {
        System.out.println("Сервер запущен.");
        try (ServerSocket serverSocket = new ServerSocket(123)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                    saveClientAddress(socket.getInetAddress().toString());
                }

                String message;
                while ((message = in.readLine()) != null) {
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println("Клиент " + socket.getInetAddress() + ": " + message);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }
    }

    private static void saveClientAddress(String address) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENTS_FILE, true))) {
            writer.write(address);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
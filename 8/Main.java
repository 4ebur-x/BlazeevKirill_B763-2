

public class Main {
    public static void main(String[] args) {
        String words1 = "Я гений этого времени";
        String alphabet1 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя ";
        char[] alphabet2 = alphabet1.toCharArray();
        char[] words2 = words1.replaceAll("\s", "").toLowerCase().toCharArray();

        for (int i = 0; i < words2.length; i++) {
            System.out.print(words2[i] + "  ");

        }
        System.out.println(" ");
        for (int i = 0; i < words2.length; i++) {
            for (int j = 0; j < alphabet2.length; j++) {
                if (alphabet2[j] == words2[i]) {
                    System.out.print((j + 1) + "  ");
                }
            }

        }
    }
}
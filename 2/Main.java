//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.print("Введите длинну массива: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] Arr = new int[n];

        int max = Arr[0];
        int min = Arr[0];

        for (int i = 0; i < n ;i++ ){
            System.out.print("Элмент "+ i+" - ");
            Arr[i] = in.nextInt();
        }

        min = Arr[0];
        for (int i = 0; i < n ;i++ ) {
            if (String.valueOf(Arr[i]).length() > String.valueOf(max).length() ){
                max = Arr[i];
            }
            if (String.valueOf(Arr[i]).length() < String.valueOf(min).length() ){
                min = Arr[i];
            }

        }
        int maxSize = String.valueOf(max).length();
        int minSize = String.valueOf(min).length();


        System.out.println("Самое длинное число - " + max + "| Его размер - "+ maxSize );
        System.out.println("Самое короткое число - " + min + "| Его размер - "+ minSize );

    }
}
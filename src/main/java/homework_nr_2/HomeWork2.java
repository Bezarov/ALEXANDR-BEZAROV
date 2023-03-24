package homework_nr_2;

import javax.crypto.spec.PSource;

public class HomeWork2 {
    public static void main(String[] args) {
        int number = 5;
        switch (number) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                break;
        }
        for (int i = 100; i <= 1000; i++)
            if (i % 5 == 0) {
                System.out.println(i);
            }
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x <= y; x++)
                System.out.print("*");
            System.out.println();
        }
        float sum = 0;
        for (float i = 1; i <= 97; i+=2) {
            sum += i / (i + 2);
        }
        System.out.println(sum);
    }
}

package homework_nr_4_additional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        JavaClock clockNoParams= new JavaClock();

        System.out.print("Укажите время после полуночи в секундах: ");
        JavaClock firstClock = new JavaClock(input.nextInt());

        for(int i = 0; i <= 9; i++){
            firstClock.tickUp();
            System.out.println("Тик: " + firstClock.seconds);
        }

        System.out.print("Укажите время ЧАСОВ 24-часовом формате: ");
        int inputHours = input.nextInt();
        System.out.print("Укажите время МИНУТ 24-часовом формате: ");
        int inputMinuts = input.nextInt();
        System.out.print("Укажите время СЕКУНД 24-часовом формате: ");
        int inputSeconds = input.nextInt();
        JavaClock secondClock = new JavaClock(inputHours, inputMinuts, inputSeconds);
        for(int i = 0; i <= 9; i++){
            secondClock.tickDown();
            System.out.println("Тик время в спять: " + secondClock.toString());
        }

        System.out.println("Время по умолчанию: " +
                clockNoParams.hours + ":" + clockNoParams.minuts + ":" + clockNoParams.seconds);

        firstClock.setClock(firstClock.seconds);

        System.out.println("Вывод переменных обьекта secondClock: " +
                secondClock.getHours() + ":" + secondClock.getMinuts() + ":" + secondClock.getSeconds());

        System.out.println("Строковое представление обьекта firstClock: " +
                firstClock.toString());
        System.out.println("Строковое представление обьекта secondClock: " +
                secondClock.toString());

        System.out.println("Сумма двух обьектов в секундном представлении: " +
                secondClock.addClock(secondClock, firstClock));
        secondClock.setClock(secondClock.addClock(secondClock, firstClock));

        System.out.println("Разница двух обьектов в секундном представлении: " +
                secondClock.subtractClock(secondClock, firstClock));
        secondClock.setClock(secondClock.subtractClock(secondClock, firstClock));
    }
}

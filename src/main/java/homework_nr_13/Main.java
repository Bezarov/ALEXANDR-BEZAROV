package homework_nr_13;

import homework_nr_13.CustomExeptions.InvalidAgeException;
import homework_nr_13.CustomExeptions.InvalidNameException;
import homework_nr_13.CustomExeptions.InvalidRangeException;

public class Main {
    public static void main(String[] args) throws InvalidAgeException, InvalidNameException, InvalidRangeException {
        Person person1 = new Person("Vasea", "Vasiliev", 145);
        System.out.println(person1.toString());

        try {
            System.out.println("Result division by 2: " + Numbers.divisionBy(7));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count the numbers divisible by 7: " + Numbers.countDivisibleBy7Numbers(25, 100));
    }
}

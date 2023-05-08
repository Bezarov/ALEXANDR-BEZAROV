package homework_nr_11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sentence = new Scanner(System.in);
        System.out.print("Enter first sentence: ");
        List<String> inputSentence = Arrays.asList(sentence.nextLine());

        Function<List, Integer> numberOfConsonants = (e -> {
            int result = e.toString().length() -2;
            for(int i = 0; i < e.toString().length(); i++) {
                if(e.toString().toLowerCase().charAt(i) == 'a'|| e.toString().toLowerCase().charAt(i) == 'e'||
                        e.toString().toLowerCase().charAt(i) == 'i' || e.toString().toLowerCase().charAt(i) == 'o' ||
                        e.toString().toLowerCase().charAt(i) == 'u')
                    result--;
            }
            return result;
        });
        System.out.println("Number of Consonants at your sentence: " + numberOfConsonants.apply(inputSentence));

        Function<List, Integer> numberOfVowels = (e -> {
            int result = 0;
            for(int i = 0; i < e.toString().length(); i++) {
                if(e.toString().toLowerCase().charAt(i) == 'a'|| e.toString().toLowerCase().charAt(i) == 'e'||
                        e.toString().toLowerCase().charAt(i) == 'i' || e.toString().toLowerCase().charAt(i) == 'o' ||
                        e.toString().toLowerCase().charAt(i) == 'u')
                    result++;
        }
            return result;
        });
        System.out.println("Number of Vowels at your sentence: " + numberOfVowels.apply(inputSentence));

        Function<List, Integer> numberOfNumbers = (e -> {
            int result = 0;
                if (e.toString().matches(".*[0-9]*"))
                    result++;
            return result;
        });
        System.out.println("Number of Numbers at your sentence: " + numberOfNumbers.apply(inputSentence));

        Function<List, String> findIfOdd = (e -> {
            if(e.toString().length() % 2 != 0)
                System.out.println("The first symbol: " + e.toString().charAt(1));
            return null;
        });
        findIfOdd.apply(inputSentence);

        Predicate<String> palindrome = (e -> {
            char[] charsArray = e.toCharArray();
            String newString = "";
            for(int i = charsArray.length - 1; i >= 0; i--)
                newString += charsArray[i];
            return e.toLowerCase().equals(newString.toLowerCase());
        });
        System.out.println("Is it a palina: " + palindrome.test("Radar"));

        Predicate<Integer> isPrime = (e -> {
            for(int i = 2; i <= e / 2; i++)
                return !(e % i == 0);
            return true;
        });
        System.out.println("Is is a Prime number: " + isPrime.test(97));
    }
}

package homework_nr_4;

public class homework_nr_4 {
    public static void main(String[] args) {
        int[] newArrayOne = new int[]{15, 18, 13, 7, 10};
        int[] newArrayTwo = new int[5];
        newArrayTwo[0] = 25;
        newArrayTwo[1] = 28;
        newArrayTwo[2] = 23;
        newArrayTwo[3] = 27;
        newArrayTwo[4] = 210;

        for (int index = 0; index != newArrayOne.length; index++)
             System.out.print(newArrayOne[index] + " ");
        System.out.print("\n");
        for (int index = 0; index != newArrayTwo.length; index++)
            System.out.print(newArrayTwo[index] + " ");

        int[][] multiDimensionArray = new int[][]{
                {13, 17, 11, 19, 14},
                {77, 11, 1234, 127, 8},
                {78, 2, 3, 4, 5}
        };
        int sum = 0;
        for (int index = 0; index != newArrayOne.length; index++)
            sum += newArrayOne[index];
        System.out.println("\n" + "\n" + "Сумма всех элементов певого массива: " + sum);

        int even = 0;
        int odd = 0;
        for (int j = 0; j != multiDimensionArray.length; j++) {
            for (int i = 0; i != multiDimensionArray[j].length; i++) {
                if (multiDimensionArray[j][i] % 2 != 0)
                    odd++;
                else even++;
            }
        }
        System.out.println("\n" + "Количество чётных чисел в двухмерном массиве: " + even);
        System.out.println("Количество НЕчётных чисел в двухмерном массиве: " + odd + "\n");

        String[] newStringArray = new String[] {"Маша", "Саша", "Петя", "Вася"};
        String[] stringArrayNew = new String[newStringArray.length];
        for(int i = 0; i != newStringArray.length; i++) {
           stringArrayNew[i] = newStringArray[i];
           System.out.println("Скопировал элемент: " + stringArrayNew[i]);
       }
    }
}
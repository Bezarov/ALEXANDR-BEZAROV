package homework_nr_13;

import homework_nr_13.CustomExeptions.InvalidRangeException;

public class Numbers extends Exception{
    public static int divisionBy(int x) throws java.lang.IllegalArgumentException{
        if (!(x == 0))
            return x / 2;
        else
            throw new IllegalArgumentException("Illegal Argument - entered number can't be 0, yours number: " + x);
    }
    public static int countDivisibleBy7Numbers(int inferiorLimit, int superiorLimit) throws InvalidRangeException {
        if (superiorLimit < inferiorLimit)
            throw new InvalidRangeException("Superior limit can't be lower than inferior limit, yours range: " +
                    "Inferior: " + inferiorLimit + " Superior: " + superiorLimit);
        int count = 0;
        for(int seven = 7; inferiorLimit != superiorLimit; inferiorLimit++)
            if (inferiorLimit % seven == 0)
                count++;
        return count;
    }
}

package homework_nr_5;

class HomeWork5 {
    public static void main(String[] args) {
        Seasons season = new Seasons(SeasonEnum.values());
        season.printAllSeasons();

        WeekdayEnum weekenum = WeekdayEnum.SUNDAY;
        System.out.println(WeekdayEnum.MONDAY.isWeekDay());
        boolean bool = Boolean.parseBoolean("true");
        System.out.println("From String to boolean: " + bool);
        byte byt = Byte.parseByte("120");
        System.out.println("From String to byte: " + byt);
        short shor = Short.parseShort("3200");
        System.out.println("From String to short: " + shor);
        int inte = Integer.parseInt("147895632");
        System.out.println("From String to int: " + inte);
        long loong = Long.parseLong("987654321987654321");
        System.out.println("From String to long: " + loong);
        double doouble = Double.parseDouble("4444.5d");
        System.out.println("From String to double: " + doouble);
        float floaat = Float.parseFloat("2354.56f");
        System.out.println("From String to float: " + floaat);

        Weekdays weekday = new Weekdays(WeekdayEnum.values());
        System.out.println(weekday.isWeekDay("SATURDAY"));
        System.out.println(weekday.isHoliday("SATURDAY"));
        System.out.println(weekday.isWeekDay("FRIDAY"));
        System.out.println(weekday.isHoliday("FRIDAY"));
    }
}

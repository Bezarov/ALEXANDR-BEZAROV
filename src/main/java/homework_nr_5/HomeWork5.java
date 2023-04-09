package homework_nr_5;

class HomeWork5 {
    public static void main(String[] args) {
        Seasons season = new Seasons(SeasonEnum.values());
        season.printAllSeasons();
        Weekdays weekday = new Weekdays(WeekdayEnum.values());
        System.out.println(weekday.isWeekDay("SATURDAY"));
        System.out.println(weekday.isHoliday("SATURDAY"));
 //       System.out.println(weekday.MONDAY.isWeekday());
        //weekday.
    }
}

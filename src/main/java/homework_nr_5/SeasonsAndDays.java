package homework_nr_5;

class Seasons {
    SeasonEnum[] season;

    Seasons(SeasonEnum[] season) {
        this.season = season;
    }

    void printAllSeasons(){
        for (int index = 0; index != season.length; index++)
            System.out.println(season[index]);
    }
}
class Weekdays {
    WeekdayEnum[] days;

    public Weekdays (WeekdayEnum[] days) {
        this.days = days;
    }
    boolean isWeekDay(String day){
        int index = WeekdayEnum.valueOf(day).ordinal();
        if (index <= 4) {
            return true;
        } else return false;
    }
    boolean isHoliday(String day){
        int index = WeekdayEnum.valueOf(day).ordinal();
        if (index > 4) {
            return true;
        } else return false;
    }
}


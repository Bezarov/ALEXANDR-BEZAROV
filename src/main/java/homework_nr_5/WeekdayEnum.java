package homework_nr_5;

public enum WeekdayEnum {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    boolean isWeekDay() {
        switch (this.ordinal()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }
    boolean isHoliday(){
        switch (this.ordinal()) {
            case 5:
            case 6:
                return true;
            default:return false;
        }
    }
}

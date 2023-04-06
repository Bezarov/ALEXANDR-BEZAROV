package homework_nr_4_additional;

public class JavaClock {
    int hours;
    int minuts;
    int seconds;
    public JavaClock() {
        hours = 12;
        minuts = 0;
        seconds = 0;
    }
    public JavaClock(int hours, int minuts, int seconds) {
        setHours(hours);
        setMinuts(minuts);
        setSeconds(seconds);
    }
    public JavaClock (int secondsSinceMidnight) {
        seconds = secondsSinceMidnight;
    }
    //Метод который собирает часы из секунд
    public void setClock(int secondsSinceMidnight){
        if (secondsSinceMidnight < 86400) {
            seconds = secondsSinceMidnight % 60;
            hours = secondsSinceMidnight / 60;
            minuts = hours % 60;
            hours = hours / 60;
            System.out.println("Сконвертировано из секунд " + secondsSinceMidnight + " в: "
                    + hours + ":" + minuts + ":" + seconds);
        }
        else System.out.println("Вы указали не валидное значение секунд:");
    }
    //Метод который разбирает время из часового представления в секунды
    public int unSetClock(JavaClock secondClock){
        int fromHours = secondClock.hours * 60 * 60;
        int fromMinuts = secondClock.minuts * 60;
        return fromHours + fromMinuts + secondClock.seconds;
    }
    public int getHours() { return hours; }
    public int getMinuts(){
        return minuts;
    }
    public int getSeconds(){
        return seconds;
    }
    public void setHours(int hours) {
        if (hours < 24 && hours > 0)
            this.hours = hours;
        else this.hours = hours / 24;
    }
    public void setMinuts(int minuts){
        if (minuts < 60 && minuts > 0)
             this.minuts = minuts;
        else this.hours += minuts / 60;
    }
    public void setSeconds(int seconds){
        if (seconds < 60 && seconds > 0)
             this.seconds = seconds;
        else this.minuts += seconds / 60;
    }
    public void tickUp(){
        setSeconds(this.seconds += 1); }
    public void tickDown(){
        if (this.seconds <= 0){
            this.minuts -= 1;
            this.seconds += 59;
            this.seconds -= 1;
        } else this.seconds -= 1; }
    //Метод который добавляет время двух обьектов и выводит сумму в секундах
    public int addClock(JavaClock secondClock, JavaClock firstClock){
         return unSetClock(secondClock) + unSetClock(firstClock);
    }
    //Метод который убавляет время двух обьектов и выводит разницу в секундах
    public int subtractClock(JavaClock secondClock, JavaClock firstClock){
        return unSetClock(secondClock) - unSetClock(firstClock);
    }
    public String toString() {
        return getHours() + ":" + getMinuts() + ":" + getSeconds();
    }

}

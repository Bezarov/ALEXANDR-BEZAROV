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
        this.hours = hours;
        this.minuts = minuts;
        this.seconds = seconds;
    }
    public JavaClock (int secondsSinceMidnight) {
        seconds = secondsSinceMidnight;
    }
    //Метод который собирает часы из секунд
    public int setClock(int secondsSinceMidnight){
        if (secondsSinceMidnight < 86400) {
            seconds = secondsSinceMidnight % 60;
            hours = secondsSinceMidnight / 60;
            minuts = hours % 60;
            hours = hours / 60;
            System.out.println("Сконвертировано из секунд " + secondsSinceMidnight + " в: "
                    + hours + ":" + minuts + ":" + seconds);
            return 1;
        }
        else return 1;
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
    public void setHours(int hours) { this.hours = hours; }
    public void setMinuts(int minuts){
        this.minuts = minuts;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public void tickUp(){ this.seconds += 1; }
    public void tickDown(){ this.seconds -= 1; }
    //Метод который добавляет время двух обьектов и выводит сумму в секундах
    public int addClock(JavaClock secondClock, JavaClock firstClock){
         return unSetClock(secondClock) + unSetClock(firstClock);
    }
    //Метод который убавляет время двух обьектов и выводит разницу в секундах
    public int subtractClock(JavaClock secondClock, JavaClock firstClock){
        return unSetClock(secondClock) - unSetClock(firstClock);
    }
    public String toString() {
        return "JavaClock{" +
                "hours=" + hours +
                ", minuts=" + minuts +
                ", seconds=" + seconds +
                '}';
    }

}

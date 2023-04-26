package homework_nr_9;

public class Programmer extends Employee implements Teachable{
    static String department = "IT";
    String programmingLanguage;

    public Programmer(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age);
        this.programmingLanguage = programmingLanguage;
    }

    public String getDepartment() {
        return department;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void teaching() {
        System.out.println(this.name + " " + this.surname + " teaching");
    }
}

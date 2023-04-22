package homework_nr_9;

public class Employee {
    String name;
    String surname;
    int age;
    static int countEmployee = 0;

    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        countEmployee++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getCountEmployee() {
        return countEmployee;
    }

    public static void setCountEmployee(int countEmployee) {
        Employee.countEmployee = countEmployee;
    }
}

package homework_nr_9;

public class Manager extends Employee implements Teachable, Interviewable{
    static String department = "Management";
    int teamManage;
    int employeeManage;

    public Manager(String name, String surname, int age, int teamManage, int employeeManage) {
        super(name, surname, age);
        this.teamManage = teamManage;
        this.employeeManage = employeeManage;
    }

    public static String getDepartment() {
        return department;
    }

    public int getTeamManage() {
        return teamManage;
    }

    public void setTeamManage(int teamManage) {
        this.teamManage = teamManage;
    }

    public int getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(int employeeManage) {
        this.employeeManage = employeeManage;
    }

    @Override
    public void interviewing() {
        System.out.println(this.name + " " + this.surname + " taking the interview");
    }

    @Override
    public void teaching() {
        System.out.println(this.name + " " + this.surname + " teaching");
    }
}

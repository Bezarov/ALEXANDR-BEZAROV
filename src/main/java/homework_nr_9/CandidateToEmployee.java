package homework_nr_9;

public class CandidateToEmployee extends Employee implements Interviewable {
    boolean candidate;

    public CandidateToEmployee(String name, String surname, int age, boolean candidat) {
        super(name, surname, age);
        this.candidate = candidat;
    }

    @Override
    public void interviewing() {
        System.out.println(this.name + " " + this.surname + " giving an interview");
    }
}

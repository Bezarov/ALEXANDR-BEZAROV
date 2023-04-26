package homework_nr_9;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Pal", "Gate", 31,2,10);
        Programmer programmer =  new Programmer("Bill", "Sterling", 33, "Java");
        CandidateToEmployee candidate = new CandidateToEmployee("Borea", "Moiseev", 25, true);

        manager.teaching();
        manager.interviewing();
        candidate.interviewing();
        programmer.teaching();

        System.out.println();
        Employee[] employeeArray = new Employee[] { manager, programmer, candidate};
        for (Employee element: employeeArray) {
            if (element instanceof Interviewable)
                ((Interviewable) element).interviewing();
        }

        System.out.println();
        MeetingRoom meeting = new MeetingRoom(employeeArray);
        meeting.callToLearning();
    }
}

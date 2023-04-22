package homework_nr_9;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    List<Teachable> employees = new ArrayList<>();

    Teachable[] teachAr = new Teachable[110];

    public MeetingRoom(Employee[] array ) {
        for (Employee element : array) {
            if (element instanceof Teachable)
                employees.add((Teachable) element);
        }
    }
    public void callToLearning(){
        System.out.println("\n" + "At the meeting room");
        for (Teachable element: employees)
            element.teaching();
    }
}

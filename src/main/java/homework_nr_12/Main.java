package homework_nr_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(
                Arrays.asList(
                        new Employee("Sasha", "Ciobanu" , 30, true, false ),
                        new Employee("Dima", "Vasilaki" , 23, true, true ),
                        new Employee("Oleg", "Vasiliev" , 47, false, false ),
                        new Employee("Andrei", "Gromov" , 35, false, true ),
                        new Employee("German", "Mos" , 33, true, true ),
                        new Employee("Alex", "Milkovskii" , 38, false, false ),
                        new Employee("Nikolai", "Serebreanu" , 22, true, true ),
                        new Employee("Vasilii", "Soloviov" , 37, true, true ),
                        new Employee("Sergei", "Zaycev" , 24, false, false ),
                        new Employee("Francesco", "Bernardini" , 40, true, true )
                )
        );

        List<String> canConductInterviewAge25 = employeeList.stream()
                .filter(e -> e.canConductInterview && e.isPayedByHour && e.age < 25)
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(canConductInterviewAge25);

        List<String> sortedByNamesEmployee = employeeList.stream()
                .filter(e -> e.getAge() > 30 && !e.isPayedByHour)
                .map(e -> e.getName())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedByNamesEmployee);

        Optional<Employee> canConductInterviewHoursPayed = employeeList.stream()
                .filter(e -> e.canConductInterview && e.isPayedByHour)
                .findFirst();
        if (canConductInterviewHoursPayed.isPresent())
            System.out.println(canConductInterviewHoursPayed.orElseThrow(() -> new RuntimeException("Employee was not found!")));

        employeeList.stream()
                .map(e -> e.getSurname())
                .sorted()
                .forEach(e -> System.out.println(e.toString()));
    }
}

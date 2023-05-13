package homework_nr_13;

import homework_nr_13.CustomExeptions.InvalidAgeException;
import homework_nr_13.CustomExeptions.InvalidNameException;

public class Person {
    String firstName;
    String lastName;
    Integer age;

    public Person(String firstName, String lastName, Integer age) throws InvalidAgeException, InvalidNameException{
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidNameException {
            if(!(firstName.equals("0")) && !(firstName.isEmpty()))
                this.firstName = firstName;
            else
                throw new InvalidNameException("Invalid name - name can't be 0 or empty string, you entered: " + firstName);
        }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidNameException {
        if(!lastName.equals("0") && !lastName.equals(""))
            this.lastName = lastName;
        else
            throw new InvalidNameException("Invalid lastname - lastname can't be 0 or empty string, you entered: " + lastName);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) throws InvalidAgeException {
        if(age > 0 && age <= 150)
            this.age = age;
        else
            throw new InvalidAgeException("Invalid entered age - age can't be 0 or more than 150, you entered: " + age);

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

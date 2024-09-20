
package BTStudent4;

import java.util.ArrayList;

public class PersonList {
    private final ArrayList<Person> personList = new ArrayList<>();

    public void addStudent() {

    }

    public void addTeacher() {

    }

    public void updatePerson(String id) {

    }

    public void deletePersonById(String id) {

    }

    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
        }
    }

    public Student findTopStudent() {
        
        return null;
        
    }

    public Teacher findTeacherByDepartment(String department) {

        return null;

    }
}

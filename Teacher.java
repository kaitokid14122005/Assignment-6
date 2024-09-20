
package BTStudent4;

import java.util.Date;
import java.util.Scanner;

public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Department: ");
        this.department = scanner.nextLine();
        System.out.print("Enter Teaching Subject: ");
        this.teachingSubject = scanner.nextLine();
    }

    @Override
    public void updatePerson(String id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Update Department: ");
        this.department = scanner.nextLine();
        System.out.print("Update Teaching Subject: ");
        this.teachingSubject = scanner.nextLine();
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }

    public String getDepartment() {
        return department;
    }
}


package BTStudent4;

import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    @Override
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter GPA: ");
        this.gpa = scanner.nextFloat();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Major: ");
        this.major = scanner.nextLine();
    }

    @Override
    public void updatePerson(String id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Update GPA: ");
        this.gpa = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Update Major: ");
        this.major = scanner.nextLine();
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }

    public float getGpa() {
        return gpa;
    }
}

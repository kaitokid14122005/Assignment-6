/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student_ver.pkg3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bao
 */
public class Student_ver3 extends Person {

    private float GPA;
    private String major;

    public Student_ver3(String id, String fullname, Date dateOfBirth, float GPA, String major) {
        super(id, fullname, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addStudent() {
          System.out.println("Addteacher: " + getFullname());
    }

    public void updateStudent(String id) {
        System.out.println("Update student: " + getFullname());
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullname());
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date of Birth: " + spf.format(getDateOfBirth()));
        System.out.println("GPA: " + getGPA());
        System.out.println("Major: " + getMajor());
    }
}

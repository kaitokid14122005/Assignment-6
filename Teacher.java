package student_ver.pkg3;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bao
 */
public class Teacher extends Person {

    private String department;
    private String teachingSubject;

    public Teacher(String id,String fullname,Date dateOfBirth,String department,String teachingSubject) {
        super(id, fullname, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullname());
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date of Birth: " + spf.format(getDateOfBirth()));
        System.out.println("GPA: " + getDepartment());
        System.out.println("Major: " + getTeachingSubject());
    }

    public void addTeacher() {
        System.out.println("Addteacher: " + getFullname());
    }

    public void updateTeacher() {
        System.out.println("Uppdate teacher: " + getFullname());
    }
}

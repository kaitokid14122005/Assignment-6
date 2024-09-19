package baitap6;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

public class Student extends Person {

    private float GPA;
    private String major;
    private double tuition;
    private boolean schoolarship;

    public Student(float GPA, String major, String id, String fullname, Date dateOfBirth, double tuition, boolean schoolarship) {
        super(id, fullname, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
        this.tuition = 10_000_000;
        this.schoolarship = GPA >= 9;// điều kiện học bổng
        if (this.schoolarship) {
            this.tuition *= 0.5;// giảm 50% học phí
        }
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public boolean isSchoolarship() {
        return schoolarship;
    }

    public void setSchoolarship(boolean schoolarship) {
        this.schoolarship = schoolarship;
        if (schoolarship) {
            this.tuition *= 0.5;
        } else {
            this.tuition = 10_000_000;
        }
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
        this.schoolarship = GPA >= 9;//Cập nhật tình trạng học bổng dựa trên GPA mới.
        this.tuition = 10_000_000;
        if (this.schoolarship) {
            this.tuition *= 0.5;
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addPerson() {
        System.out.println("Adding student: " + getFullname());
    }

    public void updatePerson() {
        // Implement the logic to update student details if necessary
        // For example, you might want to update GPA or major
        System.out.println("Updating student: " + getFullname());
    }

    public double caculateTuiition() {

        return 0;

    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullname());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date of Birth: " + dateFormat.format(getDateOfBirth())); // Format date for better readability
        System.out.println("GPA: " + GPA);
        System.out.println("Major: " + major);
        //chuyển thành 10E7 thành 10000000
        DecimalFormat df = new DecimalFormat();
        System.out.println("tuition: " + df.format(tuition));
        System.out.println("Scholarship: " + (schoolarship ? "Yes" : "No"));
    }
}

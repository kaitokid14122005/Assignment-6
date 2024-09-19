package baitap6;

import java.util.Date;

public abstract class Person implements Iperson {

    private String id;
    private String fullname;
    private Date dateOfBirth;

    public Person(String id, String fullname, Date dateOfBirth) {
        this.id = id;
        this.fullname = fullname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Phương thức trừu tượng yêu cầu các lớp con phải triển khai
    @Override
    public abstract void displayInfo();

}

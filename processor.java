package baitap6;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Find student with schoolarships");
            System.out.println("7. Calculate total tuition of all student");
            System.out.println("8. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1 -> {
                    try {
                        System.out.println("Enter student ID:");
                        String id = scanner.nextLine();
                        System.out.println("Enter full name:");
                        String name = scanner.nextLine();
                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        String dobString = scanner.nextLine();
                        Date dob = dateFormat.parse(dobString);
                        System.out.println("Enter GPA:");
                        float GPA = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Major: ");
                        String major = scanner.nextLine();
                        double tuition = 10_000_000;
                        boolean schoolarship = GPA >= 9;
                        Student student = new Student(GPA, major, id, name, dob, tuition, schoolarship);
                        studentList.addStudent(student);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    Student updateStudent = studentList.getStudentById(updateId);
                    if (updateStudent != null) {
                        System.out.print("Enter new Full Name: ");
                        String newFullName = scanner.nextLine();
                        if (!newFullName.isEmpty()) {
                            updateStudent.setFullname(newFullName);
                        }

                        System.out.print("Enter new GPA: ");
                        String newGPAInput = scanner.nextLine();
                        if (!newGPAInput.isEmpty()) {
                            float newGPA = Float.parseFloat(newGPAInput);
                            updateStudent.setGPA(newGPA);
                        }

                        System.out.print("Enter new Major: ");
                        String newMajor = scanner.nextLine();
                        if (!newMajor.isEmpty()) {
                            updateStudent.setMajor(newMajor);
                        }

                        System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
                        String newDOB = scanner.nextLine();
                        if (!newDOB.isEmpty()) {
                            try {
                                Date dateOfBirth = dateFormat.parse(newDOB);
                                updateStudent.setDateOfBirth(dateOfBirth);
                            } catch (ParseException e) {
                                System.out.println("Invalid date format. Please try again.");
                            }
                        }

                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                }
                case 3 -> {
                    System.out.println("Enter student ID to delete:");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudent(deleteId);
                }

                case 4 ->
                    studentList.displayAllStudents();

                case 5 -> {
                    Student topStudent = studentList.findHighestGpaStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                }

                case 6 -> {
                    System.out.println("Students with scholarships:");
                    for (Student student : studentList.findschooplarshipStudent()) {
                        student.displayInfo();
                    }
                }
                case 7 -> {
                    double totalTuition = studentList.calculateTuitionOfAllStudent();
                     DecimalFormat df = new DecimalFormat();
                    System.out.println("total tuition all student: " + df.format(totalTuition));
                }
                case 8 ->{
                    System.out.println("Exting...");
                    scanner.close();
                    return;
                }
                default ->System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

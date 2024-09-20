package student_ver.pkg3;

import java.text.SimpleDateFormat;
import java.util.*;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        PersonList personList = new PersonList();
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by id");
            System.out.println("5. Find person by id");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String dobString = scanner.nextLine(); // Đúng vị trí
                    Date dob = null;
                    try {
                        dob = spf.parse(dobString);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        break; // Quay lại menu nếu định dạng không hợp lệ
                    }

                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    personList.addStudent(new Student_ver3(studentId, studentName, dob, gpa, major));
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String teacherDobString = scanner.nextLine();
                    Date teacherDob = null;
                    try {
                        teacherDob = spf.parse(teacherDobString);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        break; // Quay lại menu nếu định dạng không hợp lệ
                    }
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Teaching Subject: ");
                    String teachingSubject = scanner.nextLine();
                    personList.addTeacher(new Teacher(teacherId, teacherName, teacherDob, department, teachingSubject));
                    break;
                case 3:
                    System.out.print("Enter ID of person to update: ");
                    String updateId = scanner.nextLine();
                    Person personToUpdate = personList.findPersonById(updateId);
                    if (personToUpdate != null) {
                        if (personToUpdate instanceof Student_ver3) {
                            Student_ver3 student = (Student_ver3) personToUpdate;
                            System.out.print("Enter new Name (or press Enter to keep current): ");
                            String newName = scanner.nextLine();
                            if (!newName.isEmpty()) {
                                student.setFullname(newName);
                            }
                            System.out.print("Enter new GPA (or press Enter to keep current): ");
                            String gpaInput = scanner.nextLine();
                            if (!gpaInput.isEmpty()) {
                                student.setGPA(Float.parseFloat(gpaInput));
                            }
                            System.out.print("Enter new Major (or press Enter to keep current): ");
                            String newMajor = scanner.nextLine();
                            if (!newMajor.isEmpty()) {
                                student.setMajor(newMajor);
                            }
                            System.out.println("Enter new dateofbirth (or press Enter to keep current): ");
                            String newdobString = scanner.nextLine();
                            if (!newdobString.isEmpty()) {
                                try {
                                    Date newdob = spf.parse(newdobString);
                                    student.setDateOfBirth(newdob);
                                } catch (Exception e) {
                                    System.out.println("invalid date format. please use dd/MM/yyyy.");
                                }
                            }
                        } else if (personToUpdate instanceof Teacher) {
                            Teacher teacher = (Teacher) personToUpdate;
                            System.out.print("Enter new Name (or press Enter to keep current): ");
                            String newName = scanner.nextLine();
                            if (!newName.isEmpty()) {
                                teacher.setFullname(newName);
                            }
                            System.out.print("Enter new Department (or press Enter to keep current): ");
                            String newDepartment = scanner.nextLine();
                            if (!newDepartment.isEmpty()) {
                                teacher.setDepartment(newDepartment);
                            }
                            System.out.print("Enter new Teaching Subject (or press Enter to keep current): ");
                            String newSubject = scanner.nextLine();
                            if (!newSubject.isEmpty()) {
                                teacher.setTeachingSubject(newSubject);
                            }
                            System.out.println("\"Enter new dateofbirth (or press Enter to keep current): ");
                            String newTeacherdobString = scanner.nextLine();
                            if (newTeacherdobString.isEmpty()) {
                                try {
                                    Date newTeacherdob = spf.parse(newTeacherdobString);
                                    teacher.setDateOfBirth(newTeacherdob);
                                } catch (Exception e) {
                                    System.out.println("invalid date format. please use dd/MM/yyyy.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;
                case 5:
                    System.out.print("Enter ID to find: ");
                    String findId = scanner.nextLine();
                    Person foundPerson = personList.findPersonById(findId);
                    if (foundPerson != null) {
                        foundPerson.displayInfo();
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 6:
                    personList.displayEveryone();
                    break;
                case 7:
                    Student_ver3 topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter department to find teachers: ");
                    String searchDepartment = scanner.nextLine();
                    ArrayList<Teacher> teachers = personList.findTeacherByDepartment(searchDepartment);
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers found in this department.");
                    } else {
                        for (Teacher teacher : teachers) {
                            teacher.displayInfo();
                        }
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}

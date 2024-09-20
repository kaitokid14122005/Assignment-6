package student_ver.pkg3;

import java.util.ArrayList;

class PersonList {

    private ArrayList<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public void addStudent(Student_ver3 student) {
        personList.add(student);
    }

    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
    }

    public void updatePerson(String id, Person updatePerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(id)) { // So sánh với ID
                personList.set(i, updatePerson);
                return; // Kết thúc phương thức sau khi cập nhật
            }
        }
        System.out.println("Person not found for ID: " + id); // Thông báo nếu không tìm thấy
    }

    public void deletePersonById(String id) {
        boolean removed = personList.removeIf(person -> person.getId().equals(id));
        if (!removed) {
            System.out.println("Person not found for ID: " + id); // Thông báo nếu không tìm thấy
        }
    }

    public Person findPersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void displayEveryone() { // Tên phương thức đã sửa
        for (Person person : personList) {
            person.displayInfo();
        }
    }

    public Student_ver3 findTopStudent() {
        Student_ver3 topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student_ver3) {
                if (topStudent == null || ((Student_ver3) person).getGPA() > topStudent.getGPA()) {
                    topStudent = (Student_ver3) person;
                }
            }
        }
        return topStudent;
    }

    public ArrayList<Teacher> findTeacherByDepartment(String department) { // Tên phương thức đã sửa
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Person person : personList) {
            if (person instanceof Teacher && ((Teacher) person).getDepartment().equals(department)) {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
    }
}

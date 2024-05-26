package org.example;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses = new ArrayList<>();
    private ArrayList<Double> finalScores = new ArrayList<>();
    private static int nexId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = "S" + String.format("%05d", nexId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = "S" + String.format("%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.registerStudent(this);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.dropStudent(this);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + studentName + ", Gender: " + gender + ", Address: " + address +
                ", Department: " + department + ", Registered Courses: " + registeredCourses;
    }

    public String toSimplifiedString() {
        return "ID: " + studentId + ", Name: " + studentName + ", Department: " + department.getDepartmentName();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) && studentName.equals(student.studentName);
    }

}

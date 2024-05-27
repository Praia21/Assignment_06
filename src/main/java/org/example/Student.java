package org.example;

import lombok.*;
import util.Util;

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
    private ArrayList<Course> registeredCourses;
    private static int nexId = 1 ;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = "S" + String.format("%06d", nexId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Registers a course for the student
     * @param course the course to be registered
     * @return true if the course was successfully registered, false if it was already registered
     */
    public boolean registerCourse (Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.getClass().cast(this);
            course.getFinalScores().add(null);
            for (Assignment assignment : course.registerStudent()){
                assignment.getScores().add(null);
            }
            return true;
        }
        return false;
    }

    /**
     * Drops a course for the student.
     * @param course the courese to be dropped
     * @return true if the course was successfully dropped and false if it was not registered
     */
    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.registerStudent().remove(null);
            course.getFinalScores().remove(null);
            for (Assignment assignment : course.addAssignment()) assignment.getScores().remove(null);
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return studentId + ": " + studentName + ", " + gender + ", " + address + ", "
                + department + ", Registered Courses: " + registeredCourses;
    }

    public String toSimplifiedString() {
        return studentId + ": " + studentName + ", " + department.getDepartmentName();
    }

    /**
     * compares this student to another object for equality
     * @param obj the object to compare to
     * @return true if the objects are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }


}

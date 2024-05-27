package org.example;

import lombok.*;
import util.Util;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    Department department;
    private static ArrayList<Assignment> assignments;
    private static ArrayList<Student> students;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, String s, double credits, Department department) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    public boolean registerStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            finalScores.add(null);
            for (Assignment assignment : assignments) {
                assignment.getScores().add(null);
            }
            return true;
        }
        return false;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            double weightedSum = 0;
            for (Assignment assignment : assignments) {
                if (assignment.getScores().get(i) != null) {
                    weightedSum += assignment.getScores().get(i) * assignment.getWeight();
                }
            }
            averages[i] = (int) weightedSum;
        }
        return averages;
    }

    public boolean addAssignment(Assignment assignment1) {
        Assignment assignment = new Assignment();
        return assignments.add(assignment);
    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calcStudentsAverage();
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");
        System.out.print("                    ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentName() + "   ");
        }
        System.out.println("Final Score");
        for (Student student : students) {
            System.out.print(student.getStudentName() + "             ");
            for (Assignment assignment : assignments) {
                System.out.print(assignment.getScores().get(students.indexOf(student)) + "             ");
            }
            System.out.println(finalScores.get(students.indexOf(student)));
        }
        System.out.print("Average             ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentAverage() + "             ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return courseId + ": " + courseName + ", Credits: " + credits + ", "
                + department + ", Assignments: " +
                assignments + ", Registered Students: " + students;
    }

    public String toSimplifiedString() {
        return courseId + ": " + courseName + ", Credits: " + credits + ", " + department.getDepartmentName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId.equals(course.courseId);
    }
}

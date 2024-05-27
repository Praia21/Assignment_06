package org.example;

import util.Util;

public class Main {
    public static void main(String[] args) {

        System.out.println("Testing Address class...");
        Address address1 = new Address(123,
                "Main St", "Springfield", "IL", "A1B2C3", "USA");
        Address address2 = new Address(456,
                "Elm St", "Springfield", "IL", "A1B 2C3", "USA");
        Address address3 = new Address(789,
                "Pine St", "Springfield", "IL", "INVALID", "USA");

        System.out.println("Address 1: " + address1);
        System.out.println("Address 2: " + address2);
        System.out.println("Address 3: " + address3); // Should be null


        System.out.println("\nTesting Department class...");
        Department department1 = new Department("D01", "Computer Science");
        Department department2 = new Department("D02", "Math123");

        System.out.println("Department 1: " + department1);
        System.out.println("Department 2: " + department2); // Should be null


        System.out.println("\nTesting Student class...");
        Student student1 = new Student("Alice", Gender.FEMALE, address1, department1);
        Student student2 = new Student("Bob", Gender.MALE, address2, department1);

        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);


        Course course = new Course("C-D01-01", "Programming 101", 3, department1);


        Assignment assignment1 = new Assignment("Homework 1", 0.2, 100);
        Assignment assignment2 = new Assignment("Homework 2", 0.3, 100);
        Assignment assignment3 = new Assignment("Final Exam", 0.5, 100);

        course.addAssignment(assignment1);
        course.addAssignment(assignment2);
        course.addAssignment(assignment3);

        System.out.println("Course: " + course);


        student1.registerCourse(course);
        student2.registerCourse(course);

        System.out.println("Course after registering students: " + course);


        course.generateScores();
        course.displayScores();

        String name = "alice smith";
        String titleCasedName = Util.toTitleCase(name);

        System.out.println("Original: " + name);
        System.out.println("Title cased: " + titleCasedName);

        assignment1.calcAssignmentAvg();
        System.out.println("Assignment 1 average: " + assignment1.getAssignmentAverage());

        boolean isWeightValid = course.addAssignment(assignment1);
        System.out.println("Is assignment weight valid: " + isWeightValid);
    }
}

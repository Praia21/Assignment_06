package org.example;

public class Main {
    public static void main(String[] args) {
        // Create departments
        Department computerScience = new Department();
        computerScience.setDepartmentId("D01");
        computerScience.setDepartmentName("Computer Science");

        // Create courses
        Course course = new Course();
        course.setCourseId("C001");
        course.setCourseName("Java Programming");
        course.setCredits(3.0);
        course.department = computerScience;

        // Create assignments
        Assignment assignment1 = new Assignment();
        assignment1.setAssignmentId("A001");
        assignment1.setAssignmentName("Assignment1");
        assignment1.setWeight(20); // 20% weight
        assignment1.setMaxScore(100);

        Assignment assignment2 = new Assignment();
        assignment2.setAssignmentId("A002");
        assignment2.setAssignmentName("Assignment 2");
        assignment2.setWeight(30); // 30% weight
        assignment2.setMaxScore(100);


        // Create students
        Student student1 = new Student();
        student1.setStudentId("S001");
        student1.setStudentName("Ben Over");
        student1.setGender(Gender.MALE);

        Student student2 = new Student();
        student2.setStudentId("S002");
        student2.setStudentName("Jane Smith");
        student2.setGender(Gender.FEMALE);


        // Register course to the students
        student1.registerCourse(course);
        student2.registerCourse(course);

        // Perform some tests
        System.out.println("Is assignment weight valid for course? " + course.isAssignmentWeightValid());
        System.out.println("Average assignment score for course: " + course.calcAssignmentsAverage());
        System.out.println("Average student score for course: " + course.getCourseName());
    }
}


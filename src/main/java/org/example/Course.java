package org.example;

import lombok.*;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    Department department;
    private static ArrayList<Assignment> assignments = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static String nextId;

    public static boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 100;
    }
    public static double calcAssignmentsAverage() {
        double totalScore = 0;
        int totalAssignments = 0;

        for(Assignment assignment : assignments) {
            for(Student student: students) {

            }
        }
        return totalAssignments != 0 ? totalScore / totalAssignments : 0;
    }


}

package org.example;

import lombok.*;

import java.util.ArrayList;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = "A" + String.format("%03d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
    }

    public void calcAssignmentAvg() {
        double total = 0;
        for (int score : scores) {
            total += score;
        }
        this.assignmentAverage = total / scores.size();
    }

    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int randNum = random.nextInt(11);
            int score;
            if (randNum == 0) {
                score = random.nextInt(60);
            } else if (randNum <= 2) {
                score = random.nextInt(10) + 60;
            } else if (randNum <= 4) {
                score = random.nextInt(10) + 70;
            } else if (randNum <= 8) {
                score = random.nextInt(10) + 80;
            } else {
                score = random.nextInt(11) + 90;
            }
            scores.set(i, score);
        }
    }

}

package com.example.workout.dto;

import java.util.List;

public class WorkoutPartOutput {
    public List<WorkoutOutput> workoutLogs;
    public int maxPage;

    public WorkoutPartOutput(List<WorkoutOutput> workoutLogs, int maxPage) {
        this.workoutLogs = workoutLogs;
        this.maxPage = maxPage;
    }
}
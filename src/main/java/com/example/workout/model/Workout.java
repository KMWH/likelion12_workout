package com.example.workout.model;

import com.example.workout.dto.WorkoutOutput;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String exerciseName;
    public String duration;
    public LocalDateTime date;
    public String content;

    public WorkoutOutput toWorkoutOutput(){
        return new WorkoutOutput(this.id, this.exerciseName, this.duration, this.date, this.content);
    }
}

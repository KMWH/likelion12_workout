package com.example.workout.controller;

import com.example.workout.dto.WorkoutInput;
import com.example.workout.dto.WorkoutOutput;
import com.example.workout.dto.WorkoutPartOutput;
import com.example.workout.service.WorkoutService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutLog")
@CrossOrigin(origins="*")
public class WorkoutController {

    private final WorkoutService workoutService;
    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping()
    public ResponseEntity<WorkoutOutput> createWorkout(@RequestBody WorkoutInput workoutInput){
        if (workoutInput.getExerciseName().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WorkoutOutput result = workoutService.create(workoutInput);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<WorkoutOutput>> findAllWorkouts(){
        return new ResponseEntity<>(workoutService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<WorkoutPartOutput> findPartWorkouts(@RequestParam(value = "howMany") int howMany, @RequestParam(value = "pageNum") int pageNum){
        return new ResponseEntity<>(workoutService.findPart(howMany, pageNum), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutOutput> updateWorkout(@PathVariable(value = "id") Long id, @RequestBody WorkoutInput workoutInput){
        if (workoutInput.getExerciseName().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WorkoutOutput result = workoutService.update(id, workoutInput);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable(value = "id") Long id){
        workoutService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
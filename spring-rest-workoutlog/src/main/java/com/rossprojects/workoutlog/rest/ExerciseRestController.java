package com.rossprojects.workoutlog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rossprojects.workoutlog.entity.Exercise;
import com.rossprojects.workoutlog.entity.Workout;
import com.rossprojects.workoutlog.service.ExerciseService;

@RestController
@RequestMapping("/api")
public class ExerciseRestController {

	// autowire the CustomerService
	@Autowired
	private ExerciseService exerciseService;
	
	// add mapping for GET /customers
	@GetMapping("/exercises")
	public List<Exercise> getExercises() {
		
		return exerciseService.getExercises();
	}
	
	// add mapping for GET /exercises/workouts/{workoutId}
	@GetMapping("/exercises/workout/{workoutId}")
	public List<Exercise> getExercises(@PathVariable int workoutId) {
		
		return exerciseService.getExercises(workoutId);
	}
	
	// add mapping for GET /exercises/{exerciseId}
	@GetMapping("/exercises/{exerciseId}")
	public Exercise getExercise(@PathVariable int exerciseId) {
		
		Exercise theExercise = exerciseService.getExercise(exerciseId);
		
		if (theExercise == null) {
			throw new UserNotFoundException("Exercise id not found - " + exerciseId);
		}
			
		return theExercise;
	}
	
	// add mapping for POST /exercises - add new exercise
	
	@PostMapping("/exercises")
	public Exercise addExercise(@RequestBody Exercise theExercise) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theExercise.setId(0);
		
		exerciseService.saveExercise(theExercise);
		
		return theExercise;
	}
	
	// add mapping for PUT /customers - update existing exercise
	
	@PutMapping("/exercises")
	public Exercise updateExercise(@RequestBody Exercise theExercise) {
		
		exerciseService.saveExercise(theExercise);
		
		return theExercise;
	}
	
	// add mapping for DELETE /exercises/{exerciseId} - delete exercise
	
	@DeleteMapping("/exercises/{exerciseId}")
	public String deleteExercise(@PathVariable int exerciseId) {
		
		Exercise tempExercise = exerciseService.getExercise(exerciseId);
		
		// throw exception if null
		
		if (tempExercise == null) {
			throw new UserNotFoundException("Exercise id not found - " + exerciseId);
		}
		
		exerciseService.deleteExercise(exerciseId);
		
		return "Deleted exercise id - " + exerciseId;
		
	}
	
	
	
}

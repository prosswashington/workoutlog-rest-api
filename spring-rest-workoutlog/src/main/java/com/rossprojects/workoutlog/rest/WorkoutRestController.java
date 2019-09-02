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

import com.rossprojects.workoutlog.entity.Workout;
import com.rossprojects.workoutlog.service.WorkoutService;

@RestController
@RequestMapping("/api")
public class WorkoutRestController {

	// autowire the WorkoutService
	@Autowired
	private WorkoutService workoutService;
	
	// add mapping for GET /workouts/
	@GetMapping("/workouts")
	public List<Workout> getWorkouts() {
		
		return workoutService.getWorkouts();
	}
	
	// add mapping for GET /workouts/user/{userId}
	@GetMapping("/workouts/user/{userId}")
	public List<Workout> getWorkouts(@PathVariable int userId) {
		
		return workoutService.getWorkouts(userId);
	}
	
	// add mapping for GET /workouts/{workoutId}
	@GetMapping("/workouts/{workoutId}")
	public Workout getWorkout(@PathVariable int workoutId) {
		
		Workout theWorkout = workoutService.getWorkout(workoutId);
		
		if (theWorkout == null) {
			throw new UserNotFoundException("Workout id not found - " + workoutId);
		}
			
		return theWorkout;
	}
	
	// add mapping for POST /workouts - add new workout
	
	@PostMapping("/workouts")
	public Workout addWorkout(@RequestBody Workout theWorkout) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theWorkout.setId(0);
		
		workoutService.saveWorkout(theWorkout);
		
		return theWorkout;
	}
	
	// add mapping for PUT /workouts - update existing customer
	
	@PutMapping("/workouts")
	public Workout updateWorkout(@RequestBody Workout theWorkout) {
		
		workoutService.saveWorkout(theWorkout);
		
		return theWorkout;
	}
	
	// add mapping for DELETE /workouts/{workoutId} - delete workout
	
	@DeleteMapping("/workouts/{workoutId}")
	public String deleteWorkout(@PathVariable int workoutId) {
		
		Workout tempWorkout = workoutService.getWorkout(workoutId);
		
		// throw exception if null
		
		if (tempWorkout == null) {
			throw new UserNotFoundException("Workout id not found - " + workoutId);
		}
		
		workoutService.deleteWorkout(workoutId);
		
		return "Deleted workout id - " + workoutId;
		
	}
	
	
	
}

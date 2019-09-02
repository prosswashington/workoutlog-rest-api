package com.rossprojects.workoutlog.service;

import java.util.List;

import com.rossprojects.workoutlog.entity.Workout;

public interface WorkoutService {

	public List<Workout> getWorkouts();
	
	public List<Workout> getWorkouts(int userId);

	public void saveWorkout(Workout theWorkout);

	public Workout getWorkout(int theId);

	public void deleteWorkout(int theId);
	
}

package com.rossprojects.workoutlog.dao;

import java.util.List;

import com.rossprojects.workoutlog.entity.Exercise;

public interface ExerciseDAO {

	public List<Exercise> getExercises();
	
	public List<Exercise> getExercises(int workoutId);

	public void saveExercise(Exercise theExercise);

	public Exercise getExercise(int theId);

	public void deleteExercise(int theId);
	
}

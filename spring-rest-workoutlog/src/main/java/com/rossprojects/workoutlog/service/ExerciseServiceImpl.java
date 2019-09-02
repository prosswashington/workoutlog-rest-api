package com.rossprojects.workoutlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rossprojects.workoutlog.dao.ExerciseDAO;
import com.rossprojects.workoutlog.entity.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	// need to inject customer dao
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	@Override
	@Transactional
	public List<Exercise> getExercises() {
		return exerciseDAO.getExercises();
	}

	@Override
	@Transactional
	public List<Exercise> getExercises(int workoutId) {
		return exerciseDAO.getExercises(workoutId);
	}
	
	@Override
	@Transactional
	public void saveExercise(Exercise theExercise) {

		exerciseDAO.saveExercise(theExercise);
	}

	@Override
	@Transactional
	public Exercise getExercise(int theId) {
		
		return exerciseDAO.getExercise(theId);
	}

	@Override
	@Transactional
	public void deleteExercise(int theId) {
		
		exerciseDAO.deleteExercise(theId);
	}
}






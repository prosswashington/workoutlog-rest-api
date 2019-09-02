package com.rossprojects.workoutlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rossprojects.workoutlog.dao.WorkoutDAO;
import com.rossprojects.workoutlog.entity.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	// need to inject customer dao
	@Autowired
	private WorkoutDAO workoutDAO;
	
	@Override
	@Transactional
	public List<Workout> getWorkouts() {
		return workoutDAO.getWorkouts();
	}

	@Override
	@Transactional
	public List<Workout> getWorkouts(int userId) {
		return workoutDAO.getWorkouts(userId);
	}
	
	@Override
	@Transactional
	public void saveWorkout(Workout theWorkout) {

		workoutDAO.saveWorkout(theWorkout);
	}

	@Override
	@Transactional
	public Workout getWorkout(int theId) {
		
		return workoutDAO.getWorkout(theId);
	}

	@Override
	@Transactional
	public void deleteWorkout(int theId) {
		
		workoutDAO.deleteWorkout(theId);
	}
}





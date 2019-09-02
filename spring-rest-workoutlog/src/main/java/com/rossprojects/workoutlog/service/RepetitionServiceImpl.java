package com.rossprojects.workoutlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rossprojects.workoutlog.dao.RepetitionDAO;
import com.rossprojects.workoutlog.entity.Repetition;

@Service
public class RepetitionServiceImpl implements RepetitionService {

	// need to inject customer dao
	@Autowired
	private RepetitionDAO repetitionDAO;
	
	@Override
	@Transactional
	public List<Repetition> getRepetitions() {
		return repetitionDAO.getRepetitions();
	}

	@Override
	@Transactional
	public List<Repetition> getRepetitions(int exerciseId) {
		return repetitionDAO.getRepetitions(exerciseId);
	}
	
	@Override
	@Transactional
	public void saveRepetition(Repetition theRepetition) {

		repetitionDAO.saveRepetition(theRepetition);
	}

	@Override
	@Transactional
	public Repetition getRepetition(int theId) {
		
		return repetitionDAO.getRepetition(theId);
	}

	@Override
	@Transactional
	public void deleteRepetition(int theId) {
		
		repetitionDAO.deleteRepetition(theId);
	}
}






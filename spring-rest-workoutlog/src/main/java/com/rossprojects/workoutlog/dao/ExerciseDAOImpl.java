package com.rossprojects.workoutlog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rossprojects.workoutlog.entity.Exercise;
import com.rossprojects.workoutlog.entity.Workout;

@Repository
public class ExerciseDAOImpl implements ExerciseDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Exercise> getExercises() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Exercise> theQuery = 
				currentSession.createQuery("from Exercise order by name",
										Exercise.class);
		
		// execute query and get result list
		List<Exercise> exercises = theQuery.getResultList();
				
		// return the results		
		return exercises;
	}
	
	@Override
	public List<Exercise> getExercises(int workoutId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Exercise> theQuery = 
				currentSession.createQuery("from Exercise e where e.workoutId= :workoutId order by name",
										Exercise.class);
		theQuery.setParameter("workoutId", workoutId);
		
		// execute query and get result list
		List<Exercise> exercises = theQuery.getResultList();
				
		// return the results		
		return exercises;
	}
	
	@Override
	public void saveExercise(Exercise theExercise) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Exercise
		currentSession.saveOrUpdate(theExercise);
		
	}

	@Override
	public Exercise getExercise(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Exercise theExercise = currentSession.get(Exercise.class, theId);
		
		return theExercise;
	}

	@Override
	public void deleteExercise(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Exercise where id=:exerciseId");
		theQuery.setParameter("exerciseId", theId);
		
		theQuery.executeUpdate();		
	}

}












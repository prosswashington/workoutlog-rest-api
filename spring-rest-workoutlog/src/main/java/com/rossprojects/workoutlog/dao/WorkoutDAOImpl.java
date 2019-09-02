package com.rossprojects.workoutlog.dao;

import java.util.logging.Logger;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rossprojects.workoutlog.entity.Workout;

@Repository
public class WorkoutDAOImpl implements WorkoutDAO {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Workout> getWorkouts() {
		
		logger.info("------------------------------in Workouts()------------------------------");
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		
		Query<Workout> theQuery = 
				currentSession.createQuery("from Workout order by workoutName",
											Workout.class);
		
		// execute query and get result list
		List<Workout> workouts = theQuery.getResultList();
				
		// return the results		
		return workouts;
	}

	@Override
	public List<Workout> getWorkouts(int userId) {
		
		logger.info("------------------------------in getWorkouts(userId): Calling userID:------------------------------" + userId);
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Workout> theQuery = 
				currentSession.createQuery("SELECT w FROM Workout w WHERE w.userId= :userId order by workoutName",
											Workout.class);
		theQuery.setParameter("userId", userId);
		
		// execute query and get result list
		List<Workout> workouts = theQuery.getResultList();
				
		// return the results		
		return workouts;
	}
	
	@Override
	public void saveWorkout(Workout theWorkout) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Workout
		currentSession.saveOrUpdate(theWorkout);
		
	}

	@Override
	public Workout getWorkout(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Workout theWorkout = currentSession.get(Workout.class, theId);
		
		return theWorkout;
	}

	@Override
	public void deleteWorkout(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Workout where id=:workoutId");
		theQuery.setParameter("workoutId", theId);
		
		theQuery.executeUpdate();		
	}

}












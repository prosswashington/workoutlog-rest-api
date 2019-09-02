package com.rossprojects.workoutlog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rossprojects.workoutlog.entity.Repetition;
import com.rossprojects.workoutlog.entity.Workout;

@Repository
public class RepetitionDAOImpl implements RepetitionDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Repetition> getRepetitions() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Repetition> theQuery = 
				currentSession.createQuery("from Repetition order by date, id",
								Repetition.class);
		
		// execute query and get result list
		List<Repetition> repetitions = theQuery.getResultList();
				
		// return the results		
		return repetitions;
	}

	@Override
	public List<Repetition> getRepetitions(int exerciseId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Repetition> theQuery = 
				currentSession.createQuery("from Repetition r where r.exerciseId= :exerciseId order by date, id",
											Repetition.class);
		theQuery.setParameter("exerciseId", exerciseId);
		
		// execute query and get result list
		List<Repetition> repetitions = theQuery.getResultList();
				
		// return the results		
		return repetitions;
	}
	
	@Override
	public void saveRepetition(Repetition theRepetition) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Repetition
		currentSession.saveOrUpdate(theRepetition);
		
	}

	@Override
	public Repetition getRepetition(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Repetition theRepetition = currentSession.get(Repetition.class, theId);
		
		return theRepetition;
	}

	@Override
	public void deleteRepetition(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Repetition where id=:repetitionId");
		theQuery.setParameter("repetitionId", theId);
		
		theQuery.executeUpdate();		
	}

}












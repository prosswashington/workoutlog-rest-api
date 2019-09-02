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

import com.rossprojects.workoutlog.entity.Repetition;
import com.rossprojects.workoutlog.service.RepetitionService;

@RestController
@RequestMapping("/api")
public class RepetitionRestController {

	// autowire the RepetitionrService
	@Autowired
	private RepetitionService repetitionService;
	
	// add mapping for GET /repetitions
	@GetMapping("/repetitions")
	public List<Repetition> getRepetitions() {
		
		return repetitionService.getRepetitions();
	}
	
	// add mapping for GET /repetitions/exercise/{exerciseId}
	@GetMapping("/repetitions/exercise/{exerciseId}")
	public List<Repetition> getRepetitions(@PathVariable int exerciseId) {
		
		return repetitionService.getRepetitions(exerciseId);
	}
	
	// add mapping for GET /repetitions/{repetitionId}
	@GetMapping("/repetitions/{repetitionId}")
	public Repetition getRepetition(@PathVariable int repetitionId) {
		
		Repetition theRepetition = repetitionService.getRepetition(repetitionId);
		
		if (theRepetition == null) {
			throw new UserNotFoundException("Repetition id not found - " + repetitionId);
		}
			
		return theRepetition;
	}
	
	// add mapping for POST /repetitions - add new repetition
	
	@PostMapping("/repetitions")
	public Repetition addRepetition(@RequestBody Repetition theRepetition) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theRepetition.setId(0);
		
		repetitionService.saveRepetition(theRepetition);
		
		return theRepetition;
	}
	
	// add mapping for PUT /repetitions - update existing repetition
	
	@PutMapping("/repetitions")
	public Repetition updateRepetition(@RequestBody Repetition theRepetition) {
		
		repetitionService.saveRepetition(theRepetition);
		
		return theRepetition;
	}
	
	// add mapping for DELETE /repetitions/{repetitionId} - delete repetition
	
	@DeleteMapping("/repetitions/{repetitionId}")
	public String deleteRepetition(@PathVariable int repetitionId) {
		
		Repetition tempRepetition = repetitionService.getRepetition(repetitionId);
		
		// throw exception if null
		
		if (tempRepetition == null) {
			throw new UserNotFoundException("Repetition id not found - " + repetitionId);
		}
		
		repetitionService.deleteRepetition(repetitionId);
		
		return "Deleted customer id - " + repetitionId;
		
	}
	
	
	
}

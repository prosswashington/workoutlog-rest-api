package com.rossprojects.workoutlog.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="repetition")
public class Repetition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="exercise_id")
	private int exerciseId;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="repetitions")
	private int repetitions;
	
	// Jackson default time zone is GMT. Need to convert from GMT. Central time is -05:00 ("date": "2020-11-10-0500")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddz")
	@Column(name="date")
	private Date date;
	
	public Repetition() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public Date getDate() {	
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Repetition [id=" + id + ", exerciseId=" + exerciseId + ", weight=" + weight + ", repetitions="
				+ repetitions + ", date=" + date + "]";
	}
}






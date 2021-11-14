package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Task {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String nameOfTask;
	private String dueTo;
	
	public Task(int id, String nameOfTask, String dueTo) {
		super();
		this.id = id;
		this.nameOfTask = nameOfTask;
		this.dueTo = dueTo;
	}

	public Task() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfTask() {
		return nameOfTask;
	}

	public void setNameOfTask(String nameOfTask) {
		this.nameOfTask = nameOfTask;
	}

	public String getDueTo() {
		return dueTo;
	}

	public void setDueTo(String dueTo) {
		this.dueTo = dueTo;
	}

}

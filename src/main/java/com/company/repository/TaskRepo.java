package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Task;

public interface TaskRepo extends JpaRepository<Task,Integer> {
	
	Task findByName(String nameOfTask);

}

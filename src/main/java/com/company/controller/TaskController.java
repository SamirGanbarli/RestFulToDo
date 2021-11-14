package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Task;
import com.company.repository.TaskRepo;

@RestController
public class TaskController {

	@Autowired
	private TaskRepo taskRepo;
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return taskRepo.findAll();
	}
	
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable int id) {
		
		return taskRepo.findById(id).orElse(null);
		
	}
	
	@GetMapping("/task/{name}")
	public Task getTaskByName(@PathVariable String name) {
		
		return taskRepo.findByName(name);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Task> deleteTaskById(@PathVariable int id){
		
		taskRepo.deleteById(id);
		
		return taskRepo.findAll();
	}
	
	@PostMapping("/addTasks")
	public List<Task> addTasks(@RequestBody List<Task> tasks){
		
		return taskRepo.saveAll(tasks);
		
	}
	
	@PostMapping("/addTask")
	public Task addTask(@RequestBody Task task){
		
		return taskRepo.save(task);
		
	}
	
	@PutMapping("/update")
	public Task updateTask(@RequestBody Task task){
		
		Task existingTask = taskRepo.findById(task.getId()).orElse(null);
		existingTask.setNameOfTask(task.getNameOfTask());
		existingTask.setDueTo(task.getDueTo());
		
		return taskRepo.save(existingTask);
		
	}
	
}

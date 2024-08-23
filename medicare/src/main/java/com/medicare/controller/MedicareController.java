package com.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicareController {
	
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/learn")
	public String learn(Model model) {
		String name = "Ram Sharma";
		int age = 20;
		double salary = 50000.00;
		int nums[] = {1, 4, 5, 2, 9};
		String foods[] = {"tea", "coffee", "milk"};
		Employee e1 = new Employee(101, "Sam", 800000);
		Employee e2 = new Employee(102, "Hari", 450000);
		Employee e3 = new Employee(103, "Sita", 900000);
		Employee emps[] = {e1, e2, e3};
		int number = 101;
		
		model.addAttribute("username", name);
		model.addAttribute("age", age);
		model.addAttribute("salary", salary);
		model.addAttribute("nums", nums);
		model.addAttribute("foods", foods);
		model.addAttribute("emps", emps);
		model.addAttribute("number", number);
		return "learn";
	}
}

class Employee{
	public int id;
	public String name;
	public double salary;
	
	Employee(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
}

package com.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medicare.model.Patient;
import com.medicare.service.PatientService;

@Controller
public class MedicareController {
	
	@Autowired
	PatientService patientService;

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/signup-form")
	public String signUpForm(Model model) {
		Patient patient=new Patient();
		model.addAttribute("patient",patient);
		return "signup";
		}
	
	@PostMapping("/signup")
	public String signUp(@ModelAttribute Patient patient, RedirectAttributes reda) {
	System.out.println(patient);
	boolean res = patientService.createPatient(patient);
	if(res) {
		System.out.println("Patient Created");
		reda.addFlashAttribute("message", "Account created successfully");
	} else {
		System.out.println("Err");
		reda.addFlashAttribute("message", "Something went wrong. Try with a different email.");
	}
	return "redirect:/signup-form";
	}
	
	@GetMapping("/signin-form")
	public String signInForm() {
		return "signin";
		
		}
	
	@PostMapping("/signin")
	public String signIn( 
			@RequestParam("email")String e,
			@RequestParam("password")String p,
			Model model
			) {
		System.out.println("Form Submitted");
		System.out.println(e+""+p);
		Patient patient = patientService.getPatientByEmail(e);
		System.out.println(p);
		if(patient != null) {
			if(patient.getPassword().equals(p)) {
				System.out.println("Login Successfull");				
			} else {
				model.addAttribute("message", "Invalid Password");
			}
		} else {
			model.addAttribute("message", "Invalid Email or Password");
		}
		return "signin";
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
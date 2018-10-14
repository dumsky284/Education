package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//@InitBinder  FOR ADVANCED VALIDATIONS! (IN OUR CASE TO FIRE VALIDATION ERROR IF THE STRING CONTAINS ONLY WHITESPACES
	// PRE-PROCESSING ANNOTATION @InitBinder
	// PRE PORCESSES ALL WEB REQUESTS COMING INTO THE CONTROLLER
	// removes leading and trailing whitespace. If String only has white space, trim it to null
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult theBindingResult) {
		
		System.out.println("Binding result: " + theBindingResult);
		System.out.println("\n\n\n\n");
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}
	
}
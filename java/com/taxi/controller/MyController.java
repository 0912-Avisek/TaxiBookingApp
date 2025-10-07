package com.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxi.DTO.BookingData;
import com.taxi.DTO.ContactData;
import com.taxi.Entity.BookingEntity;
import com.taxi.Entity.ContactEntity;
import com.taxi.Service.BookingService;
import com.taxi.Service.ContactFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MyController {
	
	@Autowired
	private ContactFormService contactformservice;
	
	@Autowired
	private BookingService bookingservice;
	
	
	
    
	@GetMapping(path= {"","home"})
	public String welcomepage(HttpServletRequest req, Model model) {
		
		String requestURI = req.getRequestURI();
		model.addAttribute("mycurrentpage",requestURI);
		model.addAttribute("bookingData", new BookingData());
		return "indexpage";
	}
	
	@GetMapping("cars")
	public String carsview(HttpServletRequest req, Model model) {
		
		String requestURI = req.getRequestURI();
		model.addAttribute("mycurrentpage",requestURI);
		return "carspage";
	}
	
	@GetMapping("about")
	public String Aboutview(HttpServletRequest req, Model model) {
		String requestURI = req.getRequestURI();
		model.addAttribute("mycurrentpage",requestURI);
		return "aboutpage";
	}
	
	
	@GetMapping("services")
	public String servicesview(HttpServletRequest req, Model model) {
		String requestURI = req.getRequestURI();
		model.addAttribute("mycurrentpage",requestURI);
		return "servicespage";
	}
	
	
	@GetMapping("contacts")
	public String contactsview(HttpServletRequest req, Model model) {
		
		  String requestURI = req.getRequestURI();
		  model.addAttribute("mycurrentpage",requestURI);
			 model.addAttribute("contactData",new ContactData()); 
		 
		return "contactspage";
	}
	
	
	  @PostMapping("contactform") 
	  public String contactdetail(@Valid @ModelAttribute ContactData contactdata,BindingResult
	  bs,Model m,RedirectAttributes rda) {
	  
	  if(bs.hasErrors()) {
		  m.addAttribute("BindingResult", bs); 
		  return "contactspage";
	  }
	  else {
		  ContactEntity conEntity = contactformservice.contactdataToDB(contactdata);
		  
		  if(conEntity==null) {
			  rda.addFlashAttribute("message"," Your data is not saved in Database");
			  return "redirect:/contacts";
		  }
		  else {
			  rda.addFlashAttribute("message", "Contact is saved successfully");
			  return "redirect:/contacts";
		  }
	  }
	 } 
	  
	  @PostMapping("bookingform") 
	  public String bookingdetail(@Valid @ModelAttribute BookingData bookingdata,BindingResult
	  bs,Model m,RedirectAttributes rda) {
	  
		  if(bs.hasErrors()) {
			  m.addAttribute("BindingResult",bs);
			  return "indexpage";
		  }
		  else {
			  
			  //System.out.println(bookingdata);
				
				  BookingEntity savedentity = bookingservice.bookingDetailsaveDB(bookingdata);
				  if(savedentity==null) 
				  { rda.addFlashAttribute("message","Your Booking data is not saved in DB"); 
				  return "redirect:/home";
				  }
				  
				  else {
				  rda.addFlashAttribute("message", "Your data saved successfully"); 
				  return "redirect:/home";
				  }
				 
			
			  
		  }
	  
	 }  
	  
	  
	  
	  
	 
}

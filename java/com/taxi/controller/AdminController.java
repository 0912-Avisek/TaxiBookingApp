package com.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxi.DTO.ChangepassData;
import com.taxi.DTO.ServiceData;
import com.taxi.Entity.BookingEntity;
import com.taxi.Entity.ContactEntity;
import com.taxi.Service.BookingService;
import com.taxi.Service.Checkoldcredit;
import com.taxi.Service.ContactFormService;
import com.taxi.Service.ImageService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	   private  ContactFormService  contactservice;
	   
	   private BookingService bookingservice;
	   @Autowired
	   private ImageService imageservice;
	   
	   @Autowired
	   private Checkoldcredit checkcredentials;
	   
	   @Autowired
        public void setBookingservice(BookingService bookingservice) {
		this.bookingservice = bookingservice;
	}

		@Autowired
	   public void setContactservice(ContactFormService contactservice) {
		this.contactservice = contactservice;
	}

	   @GetMapping("home")
	   public String opendashboard() {
		   return "admin/dashboard";
	   }
	   
	   @GetMapping("readAllContacts")
	   public String readAllContacts(Model model){
		   
		   List<ContactEntity> listofcontacts = contactservice.databasetopage();
		   
		   model.addAttribute("listofcontactsdetail", listofcontacts);
		   
		   return "admin/contactdetails";
	   }
	   @GetMapping("delcontactdetail/{id}")
	   public String delcontactentity(@PathVariable  int id) {
		   
		   contactservice.deletecontactdetail(id); 
		   
		   return "redirect:/admin/readAllContacts";
		  
	   }
	   
	   
	   
		
		  @GetMapping("readbookingdetail") 
		  public String readbookingdetail(Model model) {
		  
		  List<BookingEntity> listoftraveldetails = bookingservice.databaseTobookingpage();
		  model.addAttribute("listoftraveldetails", listoftraveldetails);
		  
		  return "admin/bookingdetails";
		  
		  }
		 
		  @GetMapping("addservice")
	     public String addserviceview(){
	    	   
			  return "admin/addservice";
	     }
	    
		// taking image file in the url;
		  @InitBinder
		  public void Stopbinding(WebDataBinder webdatabinder) {
			  webdatabinder.setDisallowedFields("image");
		  }
		  
		  @PostMapping("addservice")
		  public String addservicedata(@ModelAttribute ServiceData servicedata,@RequestParam("image") MultipartFile multipartfile,RedirectAttributes rda){
		    	   
			     String originalFilename = multipartfile.getOriginalFilename();
			     servicedata.setImage(originalFilename);
			     
			     
			     Boolean uploadimageDatabase = imageservice.uploadimageDatabase(servicedata, multipartfile);
			     
			     if(uploadimageDatabase) {
			    	 rda.addFlashAttribute("msg","save to database");
			    	 return "redirect:/admin/addservice";
			     }
			     else {
			    	 rda.addFlashAttribute("msg","something went wrong");
			    	 return "redirect:/admin/addservice";
			     }  
		   
		  }
		  
		@GetMapping("changepassword")  
		public String changepasswordview() {
			return "admin/changepass";
		}
		
		@PostMapping("changepassword")  
		public String changepassword(@ModelAttribute ChangepassData changedata,RedirectAttributes rda) {
			
			String oldusername = changedata.getOldusername();
			String oldpassword = changedata.getOldpassword();
			
			String newusername = changedata.getNewusername();
			String newpassword = changedata.getNewpassword();
			
			
		//	System.out.println(changedata);
			
			String result = checkcredentials.checkoldcredentials( oldusername,oldpassword);
			
		//	System.out.println(result);
			
			String ans="password Correct";
			if(result.equals(ans)) {
				
				checkcredentials.changepassword(oldusername,newusername,newpassword);
				rda.addFlashAttribute("msg", "Your Credential is Changed");
				return "redirect:/admin/home";
				
			}
			else {
				rda.addFlashAttribute("msg","Old username and Old password is wrong");
				return "redirect:/admin/changepassword";
			}
			
			
		}
	
}

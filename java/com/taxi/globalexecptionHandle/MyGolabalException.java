package com.taxi.globalexecptionHandle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyGolabalException {

	@ExceptionHandler(Exception.class)
	public String gobalexception(Exception e,RedirectAttributes rda, HttpServletRequest hsr) {
		
		
		String header = hsr.getHeader("referer");
		//	 e.printStackTrace();
		//	 System.out.println(e.getMessage());
			rda.addFlashAttribute("result", "something went wrong");
			
			return "redirect:"+header;
		
		
     }
	
	
}

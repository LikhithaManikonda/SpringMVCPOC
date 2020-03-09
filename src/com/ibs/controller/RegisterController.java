package com.ibs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.ibs.Service.UserService;
import com.ibs.model.User;

@Controller

public class RegisterController {
	@Autowired
	UserService userService;
	User userInfo;
	String creditCardNumber;
	@RequestMapping(value= "/",method = RequestMethod.GET)
	public String Register(Model model) {
	model.addAttribute("user", new User());
	return "Register";	
     }
	 @RequestMapping(value="/registerSuccess",method = RequestMethod.POST)
	  public String registerCustomerDetails(@ModelAttribute("user") User user) {
		userInfo = user;
		userService = new UserService(); 
		System.out.println(userService);
	    userService.sendUserDetailsToDAO(user);
	    return "GenerateCreditCard";
	  }
	 @RequestMapping(value="/generateCreditCardNumber",method = RequestMethod.GET)
	  public ModelAndView generateCreditCardNumber() {
		 ModelAndView modelAndView = new ModelAndView("RegisterSuccess");
		 //modelAndView.setViewName("RegisterSuccess");
		 creditCardNumber="CC".concat(Long.toString(userInfo.getPhoneNumber()));
		 modelAndView.addObject("creditCardNumber",creditCardNumber);
		 System.out.println(creditCardNumber);
		return modelAndView;
	  }
	 
	
}

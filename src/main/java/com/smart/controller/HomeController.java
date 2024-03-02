package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	
@RequestMapping("/")
	public String home(Model model) {
	model.addAttribute("title","Home - smart Contact Manager");
		return "home";
	}

@RequestMapping("/about")
public String about(Model model) {
model.addAttribute("title","About - smart Contact Manager");
	return "about";
}

@RequestMapping("/signup")
public String signup(Model model) {
model.addAttribute("title","Register - smart Contact Manager");
model.addAttribute("user", new User());
	return "signup";
    }

//handler for registering user
@RequestMapping(value="/do_register",method=RequestMethod.POST)
public String registerUser(@ModelAttribute("user")User user,@RequestParam(value="agreement",defaultValue="false")boolean agreement,Model model)

{
	if(!agreement)
	{
		System.out.println("you have not agreed the terms and condition");
	}
	
	user.setRole("ROLE_USER");
	user.setEnabled(true);
	
	
	
	System.out.println("Agreement "+agreement);
	System.out.println("User "+user);
	
	User result=this.userRepository.save(user);
	model.addAttribute("user", result);
	return "signup";
	
   }
//handler for custom login
   @GetMapping("/signin")
   public String customLogin(Model model) {
	   model.addAttribute("title","Login Page");
	   return "login";
   }

}

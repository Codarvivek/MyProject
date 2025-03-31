package com.smartcontect.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.smartcontect.dao.UserRepository;
//import com.smartcontect.entites.Users;

@Controller
public class HomeController {
	
//	@Autowired
//	private UserRepository userRepository;
//	
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("home call");
		model.addAttribute("title","Home- Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About- Smart Contact Manager");	
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("title","Signup- Smart Contact Manager");
		return "signup";
	}
	
	//register user
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") Users user,@RequestParam(value="agreement",defaultValue="false") boolean agreement ,Model model) {
		if(!agreement) {
			System.out.println("You have not agreed the terms and condition");
		}
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		model.addAttribute("user",user);
		System.out.print(user.toString());
		//Users result=this.userRepository.save(user);
		return "signup";
		
	}
}

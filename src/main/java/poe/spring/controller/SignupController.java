package poe.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
	

	@Controller
	@RequestMapping("/signup")
	public class SignupController {

	    @GetMapping
	    public String index() {
	        return "signup";
	    }

	    @PostMapping
	    public String save(String userName, RedirectAttributes attr) {
	        System.out.println("name " + userName);
	        
	        attr.addAttribute("userName", userName);
	        return "redirect:/signup/success";
	    }

	    @GetMapping("/success")
	    public String success(String userName, Model model) {
	        model.addAttribute("name", userName);
	        return "success"; // success.html
	    }
	}
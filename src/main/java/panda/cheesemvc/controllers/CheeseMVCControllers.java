package panda.cheesemvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cheese")
public class CheeseMVCControllers {
    static ArrayList<String> cheeses = new ArrayList<>();
	
	@RequestMapping (value = "")
	public String index(Model model) {
		
		model.addAttribute("cheeses",cheeses);
		model.addAttribute("title","My Top 5 Cheeses!");
		return "cheese/index";
	}
	
	@RequestMapping (value = "add", method=RequestMethod.GET)
	public String displayAddCheeseForm(Model model) {
		
		model.addAttribute("title", "Add Cheese!");
		return "cheese/add";
	}
	
	@RequestMapping (value = "add", method=RequestMethod.POST)
	public String processAddCheeseForm(@RequestParam String cheeseName,Model model) {
		
		cheeses.add(cheeseName);
		return "redirect:";
	}
	
	
}

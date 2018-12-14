package panda.cheesemvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cheese")
public class CheeseMVCControllers {
	
    static HashMap<String,String> cheeses = new HashMap<>();
	
	@RequestMapping (value = "")
	public String index(Model model) {
		
		model.addAttribute("cheeses",cheeses);
		model.addAttribute("title","ALL THE CHEZZZZ");
		return "cheese/index";
	}
	
	@RequestMapping (value = "add", method=RequestMethod.GET)
	public String displayAddCheeseForm(Model model) {
		
		model.addAttribute("title", "Add the Cheese!");
		return "cheese/add";
	}
	
	@RequestMapping (value = "add", method=RequestMethod.POST)
	public String processAddCheeseForm(@RequestParam String cheeseName, 
			@RequestParam String cheeseDesc, 
			Model model) {
	
		for (Character i : cheeseName.toCharArray()) {
			if (!Character.isLetter(i) && i != ' ') {
				model.addAttribute("title","Add the Cheese");
				model.addAttribute("error","That's a funky cheese! Try again!");
				model.addAttribute("cheeseName",cheeseName);
				model.addAttribute("cheeseDesc",cheeseDesc);
				return "cheese/add";
			}
		}
		cheeses.put(cheeseName.trim(), cheeseDesc.trim());
		return "redirect:";
	}
	
	@RequestMapping (value = "cut", method=RequestMethod.GET)
	public String displayCutCheeseForm (Model model) {

		model.addAttribute("cheeses",cheeses);
		model.addAttribute("title", "Cut the Cheese!");
		return "cheese/cut";
	}
	
	@RequestMapping (value = "cut", method=RequestMethod.POST)
	public String processCutCheeseForm(@RequestParam ArrayList<String> toCut) {
		
		for (String cut : toCut) {
			cheeses.remove(cut,cheeses.get(cut));
		}
		return "redirect:";
	}
}

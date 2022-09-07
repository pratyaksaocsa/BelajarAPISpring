package belajar.spring.api.belajarapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class WebsiteController {

    @GetMapping("/greeting")
    public String greeting(
		@RequestParam(name="name", required=false, defaultValue="World") 
		String name, Model model) {
		
		model.addAttribute("name", name);
		return "greeting";
	}
}
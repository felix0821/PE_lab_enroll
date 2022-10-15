package com.system.pe.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping({"/","/index"})
	public String index(ModelMap model) {
		return "display-page";
	}

}

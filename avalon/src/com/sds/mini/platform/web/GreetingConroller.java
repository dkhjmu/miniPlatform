package com.sds.mini.platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingConroller {
	@RequestMapping("/greeting/{name}")
	public String greeting(@PathVariable String name, Model model) {
		model.addAttribute("wowow", name);
		System.out.println(name+"!!!");
		return "forward:/greeting.html";
	}
}

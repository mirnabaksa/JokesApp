package app;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JokeController {
	@Autowired
	private JokeRepository repository;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("jokes", repository.findAll());
		return "jokeIndex";
	}
}

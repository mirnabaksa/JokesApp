package app;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class JokeController {
	@Autowired
	private JokeRepository jokeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("jokes", jokeRepository.findAll());
		return "jokeIndex";
	}
	
	@GetMapping("/new")
	public String newJokeForm(Model model) {
		model.addAttribute("jokeForm", new JokeForm());
		model.addAttribute("categories", categoryRepository.findAll());
		return "newJoke";
	}
	
	@PostMapping("/new")
	public String addNewJoke(@Valid JokeForm jokeForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println(
					bindingResult.getAllErrors().toString());
			model.addAttribute("categories", categoryRepository.findAll());
			return "newJoke";
		}
		
		Joke newJoke = new Joke(jokeForm.getContent(), jokeForm.getCategory());
		jokeRepository.save(newJoke);
		return "redirect:/";
	}
	
	@RequestMapping(value= {"/like/{id}"}, method = RequestMethod.GET)
	public String like(Model model, @PathVariable(required = true, name = "id") Integer id) {
		Joke joke = jokeRepository.getOne(id);
		joke.like();
		jokeRepository.save(joke);
		return "redirect:/";
	}
	
	@RequestMapping(value= {"/dislike/{id}"}, method = RequestMethod.GET)
	public String dislike(Model model, @PathVariable(required = true, name = "id") Integer id) {
		Joke joke = jokeRepository.getOne(id);
		joke.dislike();
		jokeRepository.save(joke);
		return "redirect:/";
	}
}

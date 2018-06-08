package app.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.db.JokeService;
import app.models.Joke;
import app.models.JokeForm;
import app.models.PageWrapper;


@Controller
public class JokeController {
	private static final int PAGING_DEFAULT = 10;
	private static final String INDEX_URL = "/";
	@Autowired
	private JokeService repository;
	
	
	@RequestMapping("/")
	public String index(Model model,@PageableDefault( value = PAGING_DEFAULT) Pageable pageable) {
		Page<Joke> jokes = repository.findAllJokes(pageable);
		model.addAttribute("pageWrapper", new PageWrapper<>(jokes, INDEX_URL));
		return "jokeIndex";
	}
	
	@GetMapping("/new")
	public String newJokeForm(Model model) {
		model.addAttribute("jokeForm", new JokeForm());
		model.addAttribute("categories", repository.findAllCategories());
		return "newJoke";
	}
	
	@PostMapping("/new")
	public String addNewJoke(@Valid JokeForm jokeForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println(
					bindingResult.getAllErrors().toString());
			model.addAttribute("categories", repository.findAllCategories());
			return "newJoke";
		}
		
		Joke newJoke = new Joke(jokeForm.getContent(), jokeForm.getCategory());
		repository.saveJoke(newJoke);
		return "redirect:/";
	}
	
	@RequestMapping(value= {"/like/{id}"}, method = RequestMethod.GET)
	public String like(Model model, @PathVariable(required = true, name = "id") Integer id) {
		Joke joke = repository.findJokeById(id);
		joke.like();
		repository.saveJoke(joke);
		return "redirect:/";
	}
	
	@RequestMapping(value= {"/dislike/{id}"}, method = RequestMethod.GET)
	public String dislike(Model model, @PathVariable(required = true, name = "id") Integer id) {
		Joke joke = repository.findJokeById(id);
		joke.dislike();
		repository.saveJoke(joke);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	private String login() {
		return "login";
	}
}

package app.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.models.Category;
import app.models.Joke;

@Service
public class JokeService {
	@Autowired
	private JokeRepository jokeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<Joke> findAllJokes(Pageable pageable) {
		return jokeRepository.findAll(pageable);
	}
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	public void saveJoke(Joke newJoke) {
		jokeRepository.save(newJoke);
		
	}
	public Joke findJokeById(Integer id) {
		return jokeRepository.findById(id).get();
	}
	
}

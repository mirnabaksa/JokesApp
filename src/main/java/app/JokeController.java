package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JokeController {

	@RequestMapping("/")
	public String index() {
		return "Welcome";
	}
}

package app;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JokeForm {
	@NotEmpty
	private String content;
	@NotNull
	private Category category;
	
	public JokeForm() {}


	public JokeForm(String content, Category category) {
		this.content = content;
		this.category = category;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}

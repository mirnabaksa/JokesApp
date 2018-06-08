package app.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Implements a joke form holder to ease form validation.
 * 
 * @author Mirna Baksa
 *
 */
public class JokeForm {
	@NotEmpty(message = "Content must contain text!")
	private String content;
	@NotNull(message = "Category must be chosen!")
	private Category category;

	public JokeForm() {
	}

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

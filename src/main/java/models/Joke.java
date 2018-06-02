package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jokes")
public class Joke {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String content;
	private int likes;
	private int dislikes;
	
	public Joke() {
	}

	public Joke(int id, String content) {
		this.id = id;
		this.content = content;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + dislikes;
		result = prime * result + id;
		result = prime * result + likes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joke other = (Joke) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (dislikes != other.dislikes)
			return false;
		if (id != other.id)
			return false;
		if (likes != other.likes)
			return false;
		return true;
	}
	
	
	
	
}

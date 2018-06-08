package app.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.models.Joke;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Integer>{

	 @Override
	 @Query(value = "SELECT j FROM Joke j ORDER BY j.likes - j.dislikes DESC, j.likes DESC")
	 Page<Joke> findAll(Pageable p);
	
}

package com.codingdojo.tvshows.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.tvshows.Models.ShowModel;
import com.codingdojo.tvshows.Models.User;

public interface ShowRepository extends CrudRepository<ShowModel, Long>{
	Optional<ShowModel> findShowById(Long id);
	List<ShowModel> findAll();
	ShowModel findShowByRating(Integer rating);
	
}

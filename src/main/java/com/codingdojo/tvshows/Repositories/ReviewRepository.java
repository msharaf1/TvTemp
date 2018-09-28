package com.codingdojo.tvshows.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tvshows.Models.ReviewModel;



@Repository
public interface ReviewRepository extends CrudRepository<ReviewModel, Long>{
	
//	List<ReviewModel> findAllReview();
	
	Optional<ReviewModel> findReviewById(Long id);
//	ReviewModel findReviewByRating(Integer rating);
	

}

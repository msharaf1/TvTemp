package com.codingdojo.tvshows.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.tvshows.Models.ReviewModel;

import com.codingdojo.tvshows.Repositories.ReviewRepository;


@Service
public class ReviewService {
	private ReviewRepository revRepo;
	
	
	public ReviewService(ReviewRepository revRepo) {
		this.revRepo=revRepo;
		
	}
	
	//create
	public void create(ReviewModel Review){
		revRepo.save(Review);
	}
	
	//read

//	public ReviewModel find(Long id){
//		return (ReviewModel)revRepo.findById(id);
//	}

	public ArrayList<ReviewModel> all(){
		return (ArrayList<ReviewModel>)revRepo.findAll();
	}

	public void update(ReviewModel Review){
		revRepo.save(Review);
	}

	public void destroy(Long id){
		revRepo.deleteById(id);
	}
}

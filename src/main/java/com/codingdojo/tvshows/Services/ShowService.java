package com.codingdojo.tvshows.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.tvshows.Models.ShowModel;
import com.codingdojo.tvshows.Repositories.ShowRepository;



@Service
public class ShowService {
	private ShowRepository showRepo;
	
	public ShowService(ShowRepository showRepo) {
		this.showRepo = showRepo;
	}
	
//	C - Create
	public ShowModel createShow(ShowModel show) {
		return showRepo.save(show);
	}
	
//	R - Read

	public ArrayList<ShowModel> findAllShows(){
		return (ArrayList<ShowModel>) showRepo.findAll();
	}
	
	public ShowModel findShowById(Long id) {
		Optional<ShowModel> optionalShow = showRepo.findShowById(id);
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
	public ShowModel findShowByRating(Integer rating) {
		return showRepo.findShowByRating(rating);
	}
	
//	U - Updated
	public ShowModel updateShow(ShowModel diffShow) {
		return showRepo.save(diffShow);
	}
	
//	D - Delete
	public void deleteShowById(Long id) {
		showRepo.deleteById(id);
	}
}

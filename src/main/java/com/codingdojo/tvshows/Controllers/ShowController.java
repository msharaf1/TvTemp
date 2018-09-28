package com.codingdojo.tvshows.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.tvshows.Models.ShowModel;
import com.codingdojo.tvshows.Models.User;
import com.codingdojo.tvshows.Services.ShowService;
import com.codingdojo.tvshows.Services.UserService;



@Controller
@RequestMapping("/shows")
public class ShowController {
	private ShowService showServ;
	private UserService userServ;
	
	public ShowController(ShowService showServ,UserService userServ){
		this.showServ = showServ;
		this.userServ = userServ;
	}

	@GetMapping("")
	public String dashboard(HttpSession session, Model model) {
		Long id = (Long)session.getAttribute("user");
		if(id == null) {
			return "redirect:/users/login";
		} else {
			User u = userServ.findUserById(id);
			model.addAttribute("shows", showServ.findAllShows());
			model.addAttribute("userObj", u);
//			model.addAttribute("userObj", userServ.findUserById((long)session.getAttribute("user")));
			return "index.jsp";
		}
		
	}
	
	@GetMapping("/newshow")
	public String newShow(HttpSession session, @ModelAttribute("creShow") ShowModel show) {
		if(session.getAttribute("user") == null) {
			return "redirect:/users/login";
		}
		return "newshow.jsp";
	}
	
	@PostMapping("/newshow")
	public String createShow(@Valid @ModelAttribute("creShow") ShowModel show, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "newshow.jsp";
		}
		long user_id = (long)session.getAttribute("user");
		User currentUser = userServ.findUserById(user_id);
		if(currentUser == null) {
			session.invalidate();
			return "redirect:/users/login";
		}
		show.setCreator(currentUser);
		showServ.createShow(show);
		return "redirect:/shows";
	}
	
	@PostMapping("/rating/{id}")
	public String likeShow(@PathVariable("id") Long show_id, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/users/login";
		}
		User currentUser = userServ.findUserById((long)session.getAttribute("user"));
		ShowModel likedShows = showServ.findShowById(show_id);
		List<User> likingUser = likedShows.getUsers();
		if(!likingUser.contains(currentUser)) {
			likingUser.add(currentUser);
			likedShows.setUsers(likingUser);
			showServ.updateShow(likedShows);
		}
		
		return "redirect:/shows"; 
	}
	

	
	@GetMapping("/{id}")
	public String showShow(@PathVariable("id") Long id, HttpSession session, Model model) {
		ShowModel show = showServ.findShowById(id);
		model.addAttribute("show", show);
//		List<User> likingUser = likedShow.getUsers();
//		model.addAttribute("shows", showServ.findAllShows());

		
		return "show.jsp";
	}

	
//	@GetMapping("/update/{id}")
//	public String showEdit(@PathVariable("id") Long id, HttpSession session, Model model) {
//		// getting session id
//		//@Valid @ModelAttribute("creShow") ShowModel show
//		User sessUser = userServ.findUserById((Long)session.getAttribute("user"));
//		ShowModel show = showServ.findShowById(id);
////		ShowModel thisshow = showServ.findShowById((Long)session.getAttribute("show")); //note the changes here ....
////		User sesUser = userServ.findByFirstName(firstName);
//		
//		// get creator id
//		User creator = show.getCreator();
//		
//		if(sessUser != creator) {
//			System.out.println("You cannot be here... sending you to show page");
//			return "redirect:/shows";
//		} else {
//			model.addAttribute("show", show);
////			model.addAttribut;
//			return "edit.jsp";
//		}
//	}
	
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/users/login";
		}
		
		
		model.addAttribute("show", showServ.findShowById(id));
		return "show.jsp";
	}
	
	@PostMapping("/update/{id}")
	public String edit(@Valid @ModelAttribute("show") ShowModel show, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "show.jsp";
		}else {
			long user_id = (long)session.getAttribute("user");
			User currentUser = userServ.findUserById(user_id);
			
			if(currentUser == null) {
				session.invalidate();
				return "redirect:/users/login";
			}
			
			
			show.setCreator(currentUser);
			showServ.createShow(show);
			
			return "redirect:/shows";
		}
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		showServ.deleteShowById(id);
		return "redirect:/shows";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
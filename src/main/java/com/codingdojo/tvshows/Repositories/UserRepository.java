package com.codingdojo.tvshows.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tvshows.Models.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User findByEmail(String email);
	User findByFirstName (String firstName);
	List<User> findAll();
	Optional<User> findUserById(Long id);

}
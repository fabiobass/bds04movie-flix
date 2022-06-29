package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
 	private ReviewRepository repository;

 	@Autowired
 	private MovieRepository movieRepository;

 	@Autowired
 	private UserService userService;

 	@Autowired
 	private AuthService authService;

 	@Transactional(readOnly = true)
 	public ReviewDTO insert(ReviewDTO dto) {
 		Review entity = new Review();
 		User user = new User();
 		user = authService.authenticated();
 		copyEntityToDTO(user, entity, dto);
 		entity = repository.save(entity);
 		return new ReviewDTO(entity, entity.getUser());

 	}

 	public void copyEntityToDTO(User user, Review entity, ReviewDTO dto) {

 		entity.setText(dto.getText());

 		Movie movie = movieRepository.getOne(dto.getMovieId());
 		entity.setMovie(movie);

 		user.setId(userService.profile().getId());
 		user.setName(userService.profile().getName());
 		user.setEmail(userService.profile().getEmail());
 		entity.setUser(user);
 	}

}

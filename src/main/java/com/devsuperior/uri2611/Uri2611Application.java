package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<MovieMinProjection> list2611 = movieRepository.search2611("Action");
		List<MovieMinDTO> listDTO2611 = list2611.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		System.out.println("---------------- M O V I E S   F O U N D   S Q L ----------------");
		for (MovieMinDTO obj : listDTO2611) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------------------");

		List<MovieMinDTO> listDTO2611X = movieRepository.search2611X("Action");

		System.out.println("--------------- M O V I E S   F O U N D   J P Q L ---------------");
		for (MovieMinDTO obj : listDTO2611X) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------------------");
	}
}

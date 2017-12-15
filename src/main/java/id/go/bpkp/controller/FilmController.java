package id.go.bpkp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.go.bpkp.dao.FilmDAO;

@Controller
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("films", filmDAO.allFilms());
		return "film/index";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int filmId, Model model) {
		model.addAttribute("film", filmDAO.getFilm(filmId));
		return "film/detail";
	}
}

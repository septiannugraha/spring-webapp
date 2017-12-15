package id.go.bpkp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.go.bpkp.dao.ActorDAO;

@Controller
@RequestMapping("/actor")
public class ActorController {
	
	@Autowired
	private ActorDAO actorDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		String[] bahasa = {
				"Melayu", "Tagalog", "Thailand"
		};
		model.addAttribute("negara", "Indonesia");
		model.addAttribute("bahasa", bahasa);
		model.addAttribute("actors", actorDAO.allActors());
		return "actor/index";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int actorId, Model model) {
		model.addAttribute("actor", actorDAO.getActor(actorId));
		return "actor/detail";
	}
	
	@GetMapping("/costar/{id}")
	public String costar(@PathVariable("id") int actorId, Model model) {
		model.addAttribute("actor", actorDAO.getActor(actorId));
		return "actor/costar";
	}
	

}

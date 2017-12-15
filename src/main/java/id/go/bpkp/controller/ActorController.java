package id.go.bpkp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.go.bpkp.dao.ActorDAO;
import id.go.bpkp.entity.Actor;

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
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("actor", new Actor());
		return "actor/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Actor actor, BindingResult result) {
		actorDAO.addActor(actor);
		return "redirect:/actor/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int actorId, Model model) {
		model.addAttribute("actor", actorDAO.getActor(actorId));
		return "actor/edit";
	}
	
	@PostMapping("/edit")
	public String edit(Actor actor) {
		actorDAO.editActor(actor);
		return "redirect:/actor/index";
	}
}

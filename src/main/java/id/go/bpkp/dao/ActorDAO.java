package id.go.bpkp.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.bpkp.entity.Actor;


@Service
public class ActorDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public List<Actor> allActors() {
		return emf.createEntityManager().createQuery("from Actor").getResultList();
	}
	
	public Actor getActor(int id) {
		return (Actor) emf.createEntityManager().createQuery("from Actor where actorId = " + id).getSingleResult();
	}


}

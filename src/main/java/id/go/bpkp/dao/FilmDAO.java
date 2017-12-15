package id.go.bpkp.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.bpkp.entity.Film;

@Service
public class FilmDAO {
	@Autowired
	private EntityManagerFactory emf;
	
	public List<Film> allFilms() {
		return emf.createEntityManager().createQuery("from Film").getResultList();
	}
	
	public Film getFilm(int id) {
		return (Film) emf.createEntityManager().createQuery("from Film where filmId = " + id).getSingleResult();
	}
}

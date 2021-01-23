package cursoSpring2.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoSpring2.curso.domain.Categoria;
import cursoSpring2.curso.repositories.CategoriaRepository;
import cursoSpring2.curso.services.exceptions.ObjectNotfoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria busca(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotfoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Categoria.class.getName()));
	}
}

package cursoSpring2.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoSpring2.curso.domain.Cliente;
import cursoSpring2.curso.repositories.ClienteRepository;
import cursoSpring2.curso.services.exceptions.ObjectNotfoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente busca(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotfoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Cliente.class.getName()));
	}
}

package cursoSpring2.curso.repositories;


import org.springframework.stereotype.Repository;

import cursoSpring2.curso.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}

package firstSpringbootProject.tutorial.rest.api.repository;

import firstSpringbootProject.tutorial.rest.api.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
}

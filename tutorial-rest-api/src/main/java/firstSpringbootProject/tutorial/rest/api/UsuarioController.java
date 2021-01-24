package firstSpringbootProject.tutorial.rest.api;

import firstSpringbootProject.tutorial.rest.api.model.UsuarioModel;
import firstSpringbootProject.tutorial.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    //-- Metodo para Salvar usuário --//
    @PostMapping(path = "/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario) {
        return repository.save(usuario);
    }

    //-- Metodo para Listar todos os usuário --//
    @RequestMapping(value = "/api/listar", method = RequestMethod.GET)
    public Iterable<UsuarioModel> Get() {
        return repository.findAll();
    }

    //-- Metodo para Consultar usuário --//
    @GetMapping(path = "/api/usuario/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //-- Metodo para Deletar usuário --//
    @RequestMapping(value = "/api/usuario/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<UsuarioModel> usuario = repository.findById((int) id);
        if(usuario.isPresent()){
            repository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package br.com.api.zoo.domain.usuario;

import br.com.api.zoo.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

        @Autowired
        UsuarioRepository usuarioRepository;

        @PostMapping("/usuario")
        public ResponseEntity<Usuario> saveUsuario (@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
                var usuario = new Usuario();
                BeanUtils.copyProperties(usuarioRecordDto, usuario);
                return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        }

        @GetMapping("/usuario")
        public ResponseEntity<List<Usuario>> getAllUsuario() {
                return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
        }

        @GetMapping("/usuario/{id}")
        public ResponseEntity<Object> getOneUsuario (@PathVariable(value="id") Long id) {
                Optional<Usuario> usuarioO = usuarioRepository.findById(id);
                if (usuarioO.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
                }
                return ResponseEntity.status(HttpStatus.OK).body(usuarioO.get());
        }

        @PutMapping("/usuario/{id}")
        public ResponseEntity<Object> updateUsuario (@PathVariable (value="id") Long id,
                                                 @RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
                Optional<Usuario> usuarioO = usuarioRepository.findById(id);
                if (usuarioO.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
                }
                var usuario = usuarioO.get();
                BeanUtils.copyProperties(usuarioRecordDto, usuario);
                return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));

        }

        @DeleteMapping("/usuario/{id}")
        public ResponseEntity<Object> deleteAdm (@PathVariable (value="id") Long id) {
                Optional<Usuario> usuarioO = usuarioRepository.findById(id);
                if (usuarioO.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body ("Usuario not found.");
                }
                usuarioRepository.delete(usuarioO.get());
                return ResponseEntity.status(HttpStatus.OK).body("Usuario deleted successfully.");
        }

}

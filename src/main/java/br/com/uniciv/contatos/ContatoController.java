package br.com.uniciv.contatos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {
	
	@Autowired
	private ContatoRepository repository;
	
	@GetMapping("/contato")
	public List<Contato> todosContatos() {
		return repository.findAll();
	}
	
	@PostMapping("/contato")
	@ResponseStatus(HttpStatus.CREATED)
	public Contato salvar(@RequestBody Contato contato) {
		return repository.save(contato);
	}
	
	@DeleteMapping("/contato")
	@ResponseStatus(HttpStatus.OK)
	public void deleta(@RequestParam String id) {
		repository.deleteById(Integer.valueOf(id));
	}
	
	@PutMapping("/contato")
	@ResponseStatus(HttpStatus.OK)
	public Contato alterar(@RequestBody Contato contato) {
		return repository.save(contato);
	}
}

package br.com.geibatisrta.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.geibatisrta.os.domain.Cliente;
import br.com.geibatisrta.os.dtos.ClienteDTO;
import br.com.geibatisrta.os.services.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		ClienteDTO objDTO = new ClienteDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}

	/*
	 * Lista todos objetos do tipo Cliente na base
	 */
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
//		log.info("RESOURCE - BUSCANDO TODOS OD TÉCNICOS");
		List<ClienteDTO> listDTO = service.findAll().stream().map(obj -> new ClienteDTO(obj))
				.collect(Collectors.toList());
//		log.info("RESOURCE - RETORNANDO RESPOSTA PARA REQUISIÇÃO");
		return ResponseEntity.ok().body(listDTO);
	}
	
	/*
	 * Cria um novo Cliente
	 */
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO) {
//		log.info("RESOURCE - CRIANDO NOVO TÉCNICO");
		Cliente newObj = service.create(objDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

//		log.info("RESOURCE - RETORNANDO RESPOSTA PARA REQUISIÇÃO");
		return ResponseEntity.created(uri).build();
	}
	
	/*
	 * Atualiza um Cliente
	 */
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO) {
//		log.info("RESOURCE - ATUALIZANDO TÉCNICO");
		ClienteDTO newObj = new ClienteDTO(service.update(id, objDTO));
//		log.info("RESOURCE - RETORNANDO RESPOSTA PARA REQUISIÇÃO");
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Delete Cliente
	 */
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		log.info("RESOURCE - DELETANDO TÉCNICO");
		service.delete(id);
//		log.info("RESOURCE - RETORNANDO RESPOSTA PARA REQUISIÇÃO");
		return ResponseEntity.noContent().build();
	}


}

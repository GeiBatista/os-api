package br.com.geibatisrta.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geibatisrta.os.domain.Cliente;
import br.com.geibatisrta.os.domain.Pessoa;
import br.com.geibatisrta.os.dtos.ClienteDTO;
import br.com.geibatisrta.os.repositories.ClienteRepository;
import br.com.geibatisrta.os.repositories.PessoaRepository;
import br.com.geibatisrta.os.services.exceptions.DataIntegratyViolationException;
import br.com.geibatisrta.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
//		log.info("SERVICE - CRIANDO NOVO TÉCNICO");
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	/*
	 * Atualiza um Cliente
	 */
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
//		log.info("SERVICE - ATUALIZANDO TÉCNICO");
		Cliente oldObj = findById(id);

		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
//		if (objDTO.getPerfis().contains(Perfil.ADMIN)) {
//			oldObj.addPerfil(Perfil.ADMIN);
//		}
		return repository.save(oldObj);
	}	
	
	/*
	 * Deleta um Cliente pelo ID
	 */
	public void delete(Integer id) {
//		log.info("SERVICE - DELETANDO TÉCNICO");
		Cliente obj = findById(id);

		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("Pessoa possui Ordens de Serviço, não pode ser deletado!");
		}

		repository.deleteById(id);
	}
	
	/*
	 * Busca Cliente pelo CPF
	 */
	private Pessoa findByCPF(ClienteDTO objDTO) {
//		log.info("SERVICE - ANALIZANDO SE O CPF ESTÁ CADASTRADO NO BANCO");
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}	
}

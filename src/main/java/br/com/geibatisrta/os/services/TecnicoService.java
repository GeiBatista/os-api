package br.com.geibatisrta.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geibatisrta.os.domain.Pessoa;
import br.com.geibatisrta.os.domain.Tecnico;
import br.com.geibatisrta.os.dtos.TecnicoDTO;
import br.com.geibatisrta.os.repositories.PessoaRepository;
import br.com.geibatisrta.os.repositories.TecnicoRepository;
import br.com.geibatisrta.os.services.exceptions.DataIntegratyViolationException;
import br.com.geibatisrta.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
//		log.info("SERVICE - CRIANDO NOVO TÉCNICO");
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	/*
	 * Atualiza um Tecnico
	 */
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
//		log.info("SERVICE - ATUALIZANDO TÉCNICO");
		Tecnico oldObj = findById(id);

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
	 * Deleta um Tecnico pelo ID
	 */
	public void delete(Integer id) {
//		log.info("SERVICE - DELETANDO TÉCNICO");
		Tecnico obj = findById(id);

		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("Técnico possui Ordens de Serviço, não pode ser deletado!");
		}

		repository.deleteById(id);
	}
	
	/*
	 * Busca Tecnico pelo CPF
	 */
	private Pessoa findByCPF(TecnicoDTO objDTO) {
//		log.info("SERVICE - ANALIZANDO SE O CPF ESTÁ CADASTRADO NO BANCO");
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}	
}

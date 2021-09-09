package br.com.geibatisrta.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geibatisrta.os.domain.Cliente;
import br.com.geibatisrta.os.domain.OS;
import br.com.geibatisrta.os.domain.Tecnico;
import br.com.geibatisrta.os.domain.enuns.Prioridade;
import br.com.geibatisrta.os.domain.enuns.Status;
import br.com.geibatisrta.os.dtos.OSDTO;
import br.com.geibatisrta.os.repositories.OSRepository;
import br.com.geibatisrta.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository repository;

	@Autowired
	private TecnicoService tecnicoService;

	@Autowired
	private ClienteService clienteService;

	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + OS.class.getName()));
	}

	public List<OS> findAll() {
		return repository.findAll();
	}

	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}

	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}

	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade().getCod()));
		newObj.setStatus(Status.toEnum(obj.getStatus().getCod()));

		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());

		newObj.setTecnico(tec);
		newObj.setCliente(cli);

		if (newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}

		return repository.save(newObj);
	}

}
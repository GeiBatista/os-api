package br.com.geibatisrta.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geibatisrta.os.domain.Cliente;
import br.com.geibatisrta.os.domain.OS;
import br.com.geibatisrta.os.domain.Tecnico;
import br.com.geibatisrta.os.domain.enuns.Prioridade;
import br.com.geibatisrta.os.domain.enuns.Status;
import br.com.geibatisrta.os.repositories.ClienteRepository;
import br.com.geibatisrta.os.repositories.OSRepository;
import br.com.geibatisrta.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;
	
	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Gei Batista", "823.241.650-58", "(71)98115-6141");
		Tecnico t2 = new Tecnico(null, "Raphael Monteiro", "427.030.430-82", "(71) 86909-0896");
		Cliente c1 = new Cliente(null, "Idlamir Oliveira", "014.808.890-24", "(71)99354-3245");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
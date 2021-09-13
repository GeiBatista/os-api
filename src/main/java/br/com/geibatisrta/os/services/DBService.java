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

		Tecnico t1 = new Tecnico(null, "Gei Batista", "823.241.650-58", "(71) 98115-6141");
		Tecnico t2 = new Tecnico(null, "Raphael Monteiro", "427.030.430-82", "(71) 86909-0896");
		Tecnico t3 = new Tecnico(null, "Sarah Rita Elaine Porto", "915.214.210-80", "(96) 98647-5093");
		Tecnico t4 = new Tecnico(null, "Calebe Pietro Peixoto", "378.149.060-24", "(31) 98697-4071");
		Tecnico t5 = new Tecnico(null, "Isabel Brenda Simone Assis", "775.611.130-30", "(69) 99144-1366");
		Tecnico t6 = new Tecnico(null, "Mateus Samuel Teixeira", "906.017.660-08", "(83) 3606-1971");
		Tecnico t7 = new Tecnico(null, "Benício Breno Hugo Fogaça", "972.127.900-52", "(96) 98336-6897");
		Tecnico t8 = new Tecnico(null, "Emilly Regina Jesus", "498.088.950-69", "(62) 99556-1891");
		Tecnico t9 = new Tecnico(null, "Sandra Camila Márcia de Paula", "250.781.250-86", "(21) 98280-1436");
		Tecnico t10 = new Tecnico(null, "Renan Carlos Sérgio Pereira", "952.336.760-95", "(86) 98363-3668");
		Tecnico t11 = new Tecnico(null, "Enrico Murilo Giovanni da Cunha", "325.568.540-06", "(96) 99266-2102");
		Tecnico t12 = new Tecnico(null, "Emilly Maria Luiza Ramos", "481.979.460-43", "(63) 99368-6420");
		Tecnico t13 = new Tecnico(null, "Elza Evelyn Sarah Lopes", "792.306.240-47", "(16) 99708-1324");
		Tecnico t14 = new Tecnico(null, "Thomas Caio Cardoso", "536.869.700-74", "(68) 98284-4192");
		Tecnico t15 = new Tecnico(null, "Clarice Marlene Teixeira", "427.254.530-20", "(86) 99276-6985");
		Tecnico t16 = new Tecnico(null, "Mariane Luiza Figueiredo", "401.772.030-72", "(92) 99771-2818");
		Tecnico t17 = new Tecnico(null, "Rebeca Valentina Mariah Ribeiro", "114.189.240-59", "(82) 98379-4750");
		Tecnico t18 = new Tecnico(null, "Allana Raimunda Elaine Vieira", "439.899.940-00", "(75) 99833-8166");
		Tecnico t19 = new Tecnico(null, "Ian Nathan da Paz", "274.452.930-35", "(85) 99178-0938");
		Tecnico t20 = new Tecnico(null, "Bárbara Jaqueline Costa", "145.038.270-30", "(92) 99317-5199");
		Cliente c1 = new Cliente(null, "Joana Rosa Mirella Oliveira", "014.808.890-24", "(83) 98697-3849");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
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
		Cliente c2 = new Cliente(null, "Nathan Caio Enrico Alves", "952.878.422-44", "(75) 99937-2191");
		Cliente c3 = new Cliente(null, "Cauã Roberto da Cruz", "242.972.827-39", "(83) 98556-9883");
		Cliente c4 = new Cliente(null, "Levi Mateus Augusto Fernandes", "922.714.040-96", "(51) 99541-8027");
		Cliente c5 = new Cliente(null, "Esther Ayla Emanuelly Castro", "980.720.487-91", "(71) 99614-7022");
		Cliente c6 = new Cliente(null, "Julia Sophie Carolina Drumond", "673.127.591-30", "(86) 98852-0050");
		Cliente c7 = new Cliente(null, "Raimundo Ricardo Teixeira", "454.761.277-39", "(79) 98573-5841");
		Cliente c8 = new Cliente(null, "Nathan Anthony Matheus Assunção", "765.879.052-42", "(84) 98940-7773");
		Cliente c9 = new Cliente(null, "Luzia Antonella Rodrigues", "102.692.643-29", "(92) 99350-5282");
		Cliente c10 = new Cliente(null, "Sophia Analu Barbosa", "385.523.982-73", "(65) 99788-2212");
		Cliente c11 = new Cliente(null, "Giovanna Débora Carla Rocha", "112.635.109-14", "(28) 55464-2062");
		Cliente c12 = new Cliente(null, "Emily Sandra Jesus", "316.965.529-90", "(37) 14729-4247");
		Cliente c13 = new Cliente(null, "Cauê Mateus Rodrigues", "231.376.348-06", "(53) 52432-8639");
		Cliente c14 = new Cliente(null, "Augusto Luiz da Paz", "829.031.436-17", "(75) 20404-3589");
		Cliente c15 = new Cliente(null, "Sueli Sebastiana Oliveira", "934.065.041-75", "(41) 18757-6339");
		Cliente c16 = new Cliente(null, "Antônia Jaqueline Fernandes", "234.392.623-91", "(27) 47428-5537");
		Cliente c17 = new Cliente(null, "Mariah Mariane Oliveira", "510.837.031-88", "(77) 28044-2356");
		Cliente c18 = new Cliente(null, "Márcia Yasmin Teresinha Ramos", "437.750.738-92", "(83) 29283-3244");
		Cliente c19 = new Cliente(null, "Agatha Julia Cristiane Gonçalves", "771.383.575-08", "(36) 25520-3681");
		Cliente c20 = new Cliente(null, "Vitor Martin Isaac Aragão", "399.602.861-00", "(60) 64307-9924");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t1, c1);
		OS os2 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t2, c3);
		OS os3 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t4, c11);
		OS os4 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t20, c19);
		OS os5 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t10, c18);
		OS os6 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t5, c11);
		OS os7 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t8, c18);
		OS os8 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t7, c7);
		OS os9 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t11, c8);
		OS os10 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t18, c20);
		OS os11 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t20, c16);

		t1.getList().add(os1);
		t2.getList().add(os2);
		t5.getList().add(os3);
		t11.getList().add(os4);
		t12.getList().add(os5);
		t4.getList().add(os6);
		c1.getList().add(os7);
		c1.getList().add(os8);
		c1.getList().add(os9);
		c1.getList().add(os10);
		c1.getList().add(os11);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
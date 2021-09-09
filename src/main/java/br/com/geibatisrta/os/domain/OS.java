package br.com.geibatisrta.os.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.geibatisrta.os.domain.enuns.Prioridade;
import br.com.geibatisrta.os.domain.enuns.Status;

@Entity
public class OS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	private Integer prioridade;
	private String observacoes;
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public OS() {
		super();
		this.setDataAbertura(LocalDateTime.now());
		this.setPrioridade(Prioridade.BAIXA);
		this.setStatus(Status.ABERTO);
	}

	public OS(Integer id, Prioridade prioridade, String observacoes, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.setDataAbertura(LocalDateTime.now()); // usuário não informa data de abertura
		this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
		this.observacoes = observacoes;
		this.status = (status == null) ? 0 : status.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCod();
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}

}

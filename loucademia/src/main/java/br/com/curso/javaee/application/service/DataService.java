package br.com.curso.javaee.application.service;




import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.curso.javaee.domain.aluno.Estado;
import br.com.curso.javaee.domain.aluno.EstadoRepository;
import br.com.curso.javaee.domain.aluno.Aluno.Sexo;
import br.com.curso.javaee.domain.aluno.Aluno.Situacao;

@Stateless //Executar a logica do negocio 
@Local
public class DataService {
	@Inject
	@EJB
	private EstadoRepository estadoRepository;

	public List<Estado> listEstados() {
		List<Estado> estados = estadoRepository.listEstados();
		return estados;
	}
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
}




















package br.com.curso.javaee.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.curso.javaee.application.service.AlunoService;
import br.com.curso.javaee.application.util.ValidationException;
import br.com.curso.javaee.domain.aluno.Aluno;

@Named
@SessionScoped
public class PesquisaAlunoBean  implements Serializable{
	
		@EJB
		private AlunoService alunoService;
	
		private FacesContext facesContext;
	
		@Inject
		@RequestParameterMap
		private Map<String, String> requestParamsMap;
		
		private String matricula;
		private String nome;
		private Integer rg;
		private Integer telefone;
		
		private List<Aluno> alunos;
		
		public void check() {
			String clear = requestParamsMap.get("clear");
			
			if (clear != null && Boolean.valueOf(clear)) {
				matricula = null;
				nome = null;
				rg = null;
				alunos = null;
			}
		}
		
		
		
		//Aluno
		public String pesquisar() {
			try {
				alunos = alunoService.listAlunos(matricula, nome, rg, telefone);
			}catch (ValidationException e) {
				facesContext.addMessage(null, new FacesMessage(e.getMessage()));
			}
			return null;
		}
		
		
		//Matrícula
		public String excluir(String matricula) {
			alunoService.delete(matricula);
			return pesquisar();
		}
		
		
		
		
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Integer getRg() {
			return rg;
		}
		public void setRg(Integer rg) {
			this.rg = rg;
		}
		public Integer getTelefone() {
			return telefone;
		}
		public void setTelefone(Integer telefone) {
			this.telefone = telefone;
		}


		public List<Aluno> getAlunos() {
			return alunos;
		}


		public void setAlunos(List<Aluno> alunos) {
			this.alunos = alunos;
		}


		public AlunoService getAlunoService() {
			return alunoService;
		}


		public void setAlunoService(AlunoService alunoService) {
			this.alunoService = alunoService;
		}
		
		
		
		
}

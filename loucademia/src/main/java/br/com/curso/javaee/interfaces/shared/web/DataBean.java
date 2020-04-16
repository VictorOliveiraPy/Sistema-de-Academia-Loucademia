package br.com.curso.javaee.interfaces.shared.web;


import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import br.com.curso.javaee.application.service.DataService;
import br.com.curso.javaee.domain.aluno.Aluno.Sexo;
import br.com.curso.javaee.domain.aluno.Aluno.Situacao;
import br.com.curso.javaee.domain.aluno.Estado;

@Named
@ApplicationScoped
@Local
public class DataBean implements Serializable{
		
		
		@EJB
		private DataService dataService;

		
		public Sexo[] getSexos() {
			return dataService.getSexos();
		}
		
		
		
		public Situacao[] getSituacoes() {
			return dataService.getSituacoes();
		}
		
		
		public List<Estado> getEstados(){
		return dataService.listEstados();
		}
		
		//Numero+DDD
		public String formatTelefone(Integer ddd, Integer numero) {
			if(ddd == null || numero == null) {
				return "";
			}
			
			
			
			return "(" + ddd + ")" + numero;
		}
		
		
}

































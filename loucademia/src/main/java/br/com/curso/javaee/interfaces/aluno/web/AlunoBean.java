package br.com.curso.javaee.interfaces.aluno.web;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.curso.javaee.application.service.AlunoService;
import br.com.curso.javaee.application.util.StringUtils;
import br.com.curso.javaee.domain.aluno.Aluno;

@Named
@RequestScoped
@Local
public class AlunoBean implements Serializable {
	
	@EJB 
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;
	
	private Aluno aluno = new Aluno();
	
	
	private String matricula;
	
	
	private String titulo = "Novo aluno";
	
	
	public void carregar() {
		
		if(!StringUtils.IsEmpty(matricula)) {
			aluno = alunoService.findByMatricula(matricula);
			titulo = "Alterar aluno";
		}
		
	}
	
	
	
	public String gravar() {
		alunoService.createOrUpdate(aluno);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso"));
		return null;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
}





































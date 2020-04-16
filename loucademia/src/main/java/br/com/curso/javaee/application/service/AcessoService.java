package br.com.curso.javaee.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.curso.javaee.application.util.StringUtils;
import br.com.curso.javaee.application.util.ValidationException;
import br.com.curso.javaee.domain.acesso.Acesso;
import br.com.curso.javaee.domain.acesso.AcessoRepository;
import br.com.curso.javaee.domain.acesso.TipoAcesso;
import br.com.curso.javaee.domain.aluno.Aluno;
import br.com.curso.javaee.domain.aluno.AlunoRepository;

@Stateless
public class AcessoService {

	
		@EJB
		private AcessoRepository acessoRepository;
		
		@EJB
		private AlunoRepository alunoRepository;
		
		public TipoAcesso registrarAcesso(String matricula, Integer rg) {
			if(StringUtils.IsEmpty(matricula) && rg == null) {
				throw new ValidationException("É preciso fornecer a matrícula ou o RG do aluno");
			}
			Aluno aluno;
			if(StringUtils.IsEmpty(matricula)) {
			aluno =	alunoRepository.findByRG(rg);
			}else {
				aluno = alunoRepository.findByMatricula(matricula);
			}
		
			if (aluno == null) {
				throw new ValidationException("O aluno não foi encontrado");
			}
			
			
			
			Acesso ultimoAcesso = acessoRepository.findUltimoAcesso(aluno);
			 TipoAcesso tipoAcesso;
			
			if(ultimoAcesso == null || ultimoAcesso.isEntradaSaidaPreenchidas()) {
				ultimoAcesso = new Acesso();
				ultimoAcesso.setAluno(aluno);
				tipoAcesso = ultimoAcesso.registrarAcesso();
				acessoRepository.store(ultimoAcesso);
				
			}else {
			tipoAcesso= ultimoAcesso.registrarAcesso();
			}
			
			return tipoAcesso;
		}
}









package br.com.curso.javaee.application.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;

import javax.ejb.Stateless;
import br.com.curso.javaee.application.util.StringUtils;
import br.com.curso.javaee.application.util.Validation;
import br.com.curso.javaee.application.util.ValidationException;
import br.com.curso.javaee.domain.acesso.Acesso;
import br.com.curso.javaee.domain.aluno.Aluno;
import br.com.curso.javaee.domain.aluno.Aluno.Situacao;
import br.com.curso.javaee.domain.aluno.AlunoRepository;
@Stateless


public class AlunoService {
	
			@EJB
			private AlunoRepository alunoRepository;
		
			public void createOrUpdate(Aluno aluno) {
				if(StringUtils.IsEmpty(aluno.getMatricula())) {
					create(aluno);
				} else {
					update(aluno);
				}
				
			}
				//Aluno
			private void create(Aluno aluno) {
				Validation.assertNotEmpty(aluno);
				
				String maxMatricula = alunoRepository.getMaxMatriculaAno();
				aluno.gerarMatricula(maxMatricula);
				alunoRepository.store(aluno);
			}
			
			//Matrícula
			public void delete(String matricula) {
				alunoRepository.delete(matricula);
			}
			
			private void update(Aluno aluno) {
				Validation.assertNotEmpty(aluno);
				Validation.assertNotEmpty(aluno.getMatricula());
				alunoRepository.update(aluno);
				
			}
			
			public Aluno findByMatricula(String matricula) {
				return alunoRepository.findByMatricula(matricula);
						
			}
				
			public List<Aluno> listAlunos(String matricula, String nome, Integer rg , Integer telefone){
				
				if(StringUtils.IsEmpty(matricula) && StringUtils.IsEmpty(nome) && rg == null &&  telefone == null) {
					throw new ValidationException("Informe ao menos um critério de pesquisa deve ser fornecido");
				}
					
				
				return alunoRepository.listAlunos(matricula, nome, rg, telefone);
						
			}
			
			public List<Aluno> listSituacoesAlunos(Situacao situacao){
				Validation.assertNotEmpty(situacao);
				return alunoRepository.listSituacoesAlunos(situacao);
			}
	
	
			public List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal){
				if (StringUtils.IsEmpty(matricula) && dataInicial == null && dataFinal == null){
					throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido");
				}
				
				return alunoRepository.listAcessosAlunos(matricula, dataInicial, dataFinal);
			}
			
	
}



























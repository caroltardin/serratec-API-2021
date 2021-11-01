package org.serratec.backend.exercicio01.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.exercicio01.domain.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private static List<Aluno> lista = new ArrayList<Aluno>();
	
	static {
		lista.add(new Aluno("Carla", 2340L, "111111111"));
		lista.add(new Aluno("Carlos", 2342l, "2222222222"));
		lista.add(new Aluno("Maria", 1409l, "33333333333"));
	}
	
	@GetMapping
	public List<Aluno> listar(){
		return lista;
	}
	
	@GetMapping("{matricula}")
	public Aluno buscar(@PathVariable Long matricula){
		for(Aluno aluno: lista){
			if(aluno.getMatricula().equals(matricula))
			return aluno;
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno inserir(@RequestBody Aluno aluno) {
		lista.add(aluno);
		return aluno;
	}

	@PutMapping("{matricula}")
	public Aluno alterar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
		
		for(Aluno lista_aluno: lista){
			if(lista_aluno.getMatricula().equals(matricula)) {
            Aluno alunoAtualizado = new Aluno(aluno.getNome(), aluno.getMatricula(), aluno.getTelefone());
			lista.set(matricula.intValue(), alunoAtualizado);
			return alunoAtualizado;
			}
		}
		return null;
	}
	
//	Não consegui fazer por for each
//	@PutMapping("{matricula}")
//    public Aluno alterar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
//        for(int i = 0; i < lista.size(); i++) {
//            if(lista.get(i).getMatricula().equals(matricula)) {
//                Aluno v = new Aluno(aluno.getNome(), aluno.getMatricula(), aluno.getTelefone());
//                lista.set(i, v);
//                return v;
//            }
//        }
//        return null;
//    }
	
	@DeleteMapping("{matricula}")
	public void delete(@PathVariable Long matricula){
		for(Aluno aluno: lista){
			if(aluno.getMatricula().equals(matricula))
			lista.remove(aluno);
		}
	}

}
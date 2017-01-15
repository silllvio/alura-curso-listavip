package br.com.alura.listavip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.listavip.models.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@RequestMapping("convidados")
@Controller
public class ConvidadoController {
	

	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String lista(Model model){
		
//		Convidado convidados2 = new Convidado();
//		convidados2.setNome("Silvio hotmail");
//		convidados2.setEmail("silllvio@hotmail.com");
//		convidados2.setTelefone("999999999");
//		
//		repository.save(convidados2);
		
	    Iterable<Convidado> convidados = repository.findAll();
	    model.addAttribute("convidados", convidados);
		
		
		return "convidados/convidados";
	}

	
	
}

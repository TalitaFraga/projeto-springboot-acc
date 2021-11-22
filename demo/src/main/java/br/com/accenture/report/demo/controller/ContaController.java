package br.com.accenture.report.demo.controller;



import br.com.accenture.report.demo.model.Contas;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.accenture.report.demo.service.ContaService;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ContaController {

    @Autowired
    private ContaService contaService;

//    @GetMapping("/hello2")
//    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
//    }


    //MÉTODO PARA BUSCAR TODAS AS CONTAS
    @GetMapping("/contas")
    public List<Contas> buscarConta(){
//        System.out.println(this.contaService);
        return this.contaService.buscarContas();
    }

    //MÉTODO PARA SALVAR CONTA
    @PostMapping("/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarConta(@RequestBody Contas conta){
        this.contaService.salvarConta(conta);
    }

//    //MÉTODO PARA ALTERAR CONTA
    @PutMapping("/contas/{id}")
    public void alterarConta(@PathVariable("id") Long id, @RequestBody Contas conta){
        this.contaService.atualizarConta(conta, id);
    }

    //MÉTODO PARA DELETAR CONTA
    @DeleteMapping("/contas/{id}")
    public String deletarConta(@PathVariable("id") Long id){
        this.contaService.deletarConta(id);
        return "Conta excluída com sucesso";
    }

}
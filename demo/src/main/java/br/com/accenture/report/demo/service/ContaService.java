package br.com.accenture.report.demo.service;

import br.com.accenture.report.demo.repository.ContaRepository;
import ch.qos.logback.core.net.server.Client;
import lombok.Data;
import br.com.accenture.report.demo.model.Contas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Data
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    //MÉTODO PARA BUSCAR TODAS AS CONTAS
    public List<Contas> buscarContas(){
        return this.contaRepository.findAll();
    }

    //METODO PARA SALVAR CONTA
    public void salvarConta(Contas conta){
        this.contaRepository.save(conta);
    }

    //MÉTODO PARA ATUALIZAR CONTA
    public void atualizarConta(Contas conta, Long id){
        Contas contaBD = this.contaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta não encontrada"));
        conta.setIdConta(id);
        BeanUtils.copyProperties(conta, contaBD, "id");
        this.salvarConta(contaBD);
    }

    //MÉTODO PARA DELETAR CONTA
    public void deletarConta(Long id){
        this.contaRepository.deleteById(id);
    }

}

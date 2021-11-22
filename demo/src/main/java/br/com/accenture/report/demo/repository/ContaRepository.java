package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Contas, Long>{

}

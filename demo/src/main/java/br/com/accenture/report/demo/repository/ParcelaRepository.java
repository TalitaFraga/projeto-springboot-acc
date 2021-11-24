package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

}

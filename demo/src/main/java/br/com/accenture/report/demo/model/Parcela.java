package br.com.accenture.report.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "parcela")
public class Parcela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_conta")
    private Long idConta;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parcela")
    private Long idParcela;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "numero")
    private Integer numero;


    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Contas conta;


    public Parcela(LocalDate contaData, Integer contaParcelas, Long idConta) {
        this.data = contaData;
        this.numero = contaParcelas;
        this.idConta = idConta;

    }


    public Parcela() {

    }
}





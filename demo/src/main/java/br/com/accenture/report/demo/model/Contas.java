package br.com.accenture.report.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "conta")
@Data
@Getter @Setter
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long idConta;

    @NotNull
    @Column(name = "descricao")
    private String contaDescricao;

    @NotNull
    @Column(name = "valor")
    private double contaValor;

    @NotNull
    @Column(name = "data")
    private LocalDate contaData;

    @NotNull
    @Column(name = "tipo_compra")
    private String contaTipoCompra;

    @Column(name = "parcelas")
    private Integer contaParcelas;

    @Column(name = "mes")
    private String contaMes;

    @OneToMany(mappedBy = "conta")
    private List<Parcela> parcela;

//    @Transient
//    private Integer contaParcela;

    @Transient
    private double contaValorParcela;

    public Contas(){

    }

    public Contas(String contaDescricao, double contaValor, LocalDate contaData, String contaTipoCompra, Integer contaParcelas, String contaMes){
        this.contaDescricao = contaDescricao;
        this.contaValor = contaValor;
        this.contaData = contaData;
        this.contaTipoCompra = contaTipoCompra;
        this.contaParcelas = contaParcelas;
        this.contaMes = contaMes;

    }


//    public Integer getContaParcela() {
//        return contaParcela;
//    }
//
//    public void setContaParcela(Integer contaParcela) {
//        this.contaParcela = contaParcela;
//    }

    public double getContaValorParcela() {
        if(this.contaParcelas != null){
            contaValorParcela = this.contaValor/this.contaParcelas;
        } else {
            this.contaValorParcela = this.contaValor;
        }
        return contaValorParcela;
    }

    public void setContaValorParcela(double contaValorParcela) {
        this.contaValorParcela = contaValorParcela;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contas other = (Contas) obj;
        if (idConta == null) {
            if (other.idConta != null)
                return false;
        } else if (!idConta.equals(other.idConta))
            return false;
        return true;
    }
}

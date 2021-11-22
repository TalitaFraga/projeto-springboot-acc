package br.com.accenture.report.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity(name = "Conta")
@Data
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long idConta;

    @NotNull
    @Column(name = "descricao")
    private String contaDescricao;

    @NotNull
    @Column(name = "valor")
    private double contaValor;

    @NotNull
    @Column(name = "data")
    private Date contaData;

    @NotNull
    @Column(name = "tipo_compra")
    private String contaTipoCompra;

    @Column(name = "parcelas")
    private Integer contaParcelas;

    @Column(name = "mes")
    private String contaMes;

    public Contas(){

    }

    public Contas(String contaDescricao, double contaValor, Date contaData, String contaTipoCompra, int contaParcelas, String contaMes){
        this.contaDescricao = contaDescricao;
        this.contaValor = contaValor;
        this.contaData = contaData;
        this.contaTipoCompra = contaTipoCompra;
        this.contaParcelas = contaParcelas;
        this.contaMes = contaMes;
    }

    public String getContaDescricao() {
        return contaDescricao;
    }

    public void setContaDescricao(String contaDescricao) {
        this.contaDescricao = contaDescricao;
    }

    public double getContaValor() {
        return contaValor;
    }

    public void setContaValor(double contaValor) {
        this.contaValor = contaValor;
    }

    public Date getContaData() {
        return contaData;
    }

    public void setContaData(Date contaData) {
        this.contaData = contaData;
    }

    public String getContaTipoCompra() {
        return contaTipoCompra;
    }

    public void setContaTipoCompra(String contaTipoCompra) {
        this.contaTipoCompra = contaTipoCompra;
    }

    public Integer getContaParcelas() {
        return contaParcelas;
    }

    public void setContaParcelas(Integer contaParcelas) {
        this.contaParcelas = contaParcelas;
    }

    public String getContaMes() {
        return contaMes;
    }

    public void setContaMes(String contaMes) {
        this.contaMes = contaMes;
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

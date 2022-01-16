package com.cursojpa.cursojpa.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cursojpa.cursojpa.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;


    private Date dataVencimento;
    private Date dataPagamento;
    
    public PagamentoComBoleto(){
        
    }

    public PagamentoComBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento,
            Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


}

package com.TQI.tqi_evolution_backend_2021.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valor;
    private LocalDate primeiraParcela;
    private int quantidadeParcelas;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getCodigo() {
        return id;
    }

    public void setCodigo(Long codigo) {
        this.id = codigo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public LocalDate getPrimeiraParcela() {
        return primeiraParcela;
    }

    public void setPrimeiraParcela(LocalDate primeiraParcela) {
        this.primeiraParcela = primeiraParcela;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

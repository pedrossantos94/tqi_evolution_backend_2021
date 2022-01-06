package com.TQI.tqi_evolution_backend_2021.datatransferobjects;

import com.TQI.tqi_evolution_backend_2021.model.Solicitacao;
import com.TQI.tqi_evolution_backend_2021.validator.dataIsValid;
import com.TQI.tqi_evolution_backend_2021.validator.dataParcelaIsValid;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaSolicitacao {

    @NotBlank(message = "O campo não pode estar em branco.")
    @Min(value = 1, message = "O valor da solicitação não pode ser zero.")
    private String valor;

    @NotBlank(message = "O campo não pode estar em branco.")
    @Min(value = 1, message = "O número de parcelas não pode ser zero.")
    @Max(value = 60, message = "O número de parcelas não pode ser maior que 60.")
    private String quantidadeParcelas;

    @dataIsValid(message = "A data informada é inválida.")
    @dataParcelaIsValid
    private String dataPrimeiraParcela;

    public Solicitacao toSolicitacao() {
        Solicitacao novaSolicitacao = new Solicitacao();
        novaSolicitacao.setValor(Float.parseFloat(valor));
        novaSolicitacao.setQuantidadeParcelas(Integer.parseInt(quantidadeParcelas));
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        novaSolicitacao.setPrimeiraParcela(LocalDate.parse(dataPrimeiraParcela, formatoData));
        return novaSolicitacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(String quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(String dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }
}

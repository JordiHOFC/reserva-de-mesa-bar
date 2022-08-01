package br.com.github.jordihofc.reserva.mesa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class MesaIndisponivelException extends RuntimeException {
    public MesaIndisponivelException(String mensagem) {
        super(mensagem);
    }
}

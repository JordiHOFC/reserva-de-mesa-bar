package br.com.github.jordihofc.reserva.mesa;

import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Mesa {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer quantidadeDeLugares;

    @Column(nullable = false)
    private boolean disponivelParaReserva;

    public Mesa(Integer quantidadeDeLugares) {
        this.quantidadeDeLugares = quantidadeDeLugares;
        this.disponivelParaReserva=true;
    }

    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Mesa() {
    }

    public Long getId() {
        return id;
    }

    public Reserva reservar(Usuario usuario, LocalDateTime dataReserva) {
        if(!disponivelParaReserva){
            throw  new MesaIndisponivelException("Mesa indisponivel para reserva");
        }

        this.disponivelParaReserva=false;
        return new Reserva(this,usuario,dataReserva);
    }
}

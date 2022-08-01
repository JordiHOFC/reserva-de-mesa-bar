package br.com.github.jordihofc.reserva.mesa;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

@Entity
public class Reserva {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Mesa mesa;

    @ManyToOne(optional = false)
    private Usuario reservadoPor;

    @Column(nullable = false)
    private LocalDateTime reservadoPara;

    @Column(nullable = false)
    private LocalDateTime criadoEm = now();

    public Reserva(Mesa mesa, Usuario reservadoPor, LocalDateTime reservadoPara) {
        this.mesa = mesa;
        this.reservadoPor = reservadoPor;
        this.reservadoPara = reservadoPara;
    }

    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Reserva() {
    }

    public Long getId() {
        return id;
    }
}

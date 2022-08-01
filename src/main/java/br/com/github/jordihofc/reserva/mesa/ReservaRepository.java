package br.com.github.jordihofc.reserva.mesa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsMesaByIdAndReservadoParaIs(Long id, LocalDateTime dataReserva);
}

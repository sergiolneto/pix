package br.com.itau.pix.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.pix.modelo.Pix;

public interface Cadpix extends JpaRepository<Pix, UUID>{


}

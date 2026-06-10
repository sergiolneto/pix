package br.com.pix.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pix.modelo.ChavePix;

public interface Cadpix extends JpaRepository<ChavePix, UUID>{


}

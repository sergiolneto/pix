package br.com.bank.pix.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bank.pix.modelo.Pix;

public interface Cadpix extends JpaRepository<Pix, UUID>{


}

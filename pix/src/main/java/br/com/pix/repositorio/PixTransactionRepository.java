package br.com.pix.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pix.modelo.PixTransaction;

public interface PixTransactionRepository extends JpaRepository<PixTransaction, String> {
}

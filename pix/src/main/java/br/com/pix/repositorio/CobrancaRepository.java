package br.com.pix.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pix.modelo.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, String> {
}

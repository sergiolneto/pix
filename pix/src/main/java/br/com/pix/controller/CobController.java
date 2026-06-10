package br.com.pix.controller;

import br.com.pix.modelo.Cobranca;
import br.com.pix.repositorio.CobrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/cob")
public class CobController {

    @Autowired
    private CobrancaRepository cobrancaRepository;

    @PutMapping("/{txid}")
    public ResponseEntity<Cobranca> criarOuAtualizar(@PathVariable String txid, @RequestBody Cobranca cob) {
        cob.setTxid(txid);
        if (cob.getDataCriacao() == null) {
            cob.setDataCriacao(Instant.now());
        }
        if (cob.getStatus() == null) {
            cob.setStatus("ATIVA");
        }
        Cobranca salva = cobrancaRepository.save(cob);
        return new ResponseEntity<>(salva, HttpStatus.CREATED);
    }

    @GetMapping("/{txid}")
    public ResponseEntity<Cobranca> consultar(@PathVariable String txid) {
        return cobrancaRepository.findById(txid)
                .map(cob -> new ResponseEntity<>(cob, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Cobranca> listar() {
        return cobrancaRepository.findAll();
    }
}

package br.com.pix.controller;

import br.com.pix.modelo.PixTransaction;
import br.com.pix.repositorio.PixTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pix")
public class PixController {

    @Autowired
    private PixTransactionRepository pixRepository;

    @GetMapping("/{e2eid}")
    public ResponseEntity<PixTransaction> consultar(@PathVariable String e2eid) {
        return pixRepository.findById(e2eid)
                .map(pix -> new ResponseEntity<>(pix, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<PixTransaction> listar() {
        return pixRepository.findAll();
    }
}

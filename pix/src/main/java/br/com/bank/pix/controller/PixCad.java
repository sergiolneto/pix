package br.com.bank.pix.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bank.pix.modelo.Pix;
import br.com.bank.pix.repositorio.Cadpix;
import br.com.bank.pix.validadores.*;


@RestController
@RequestMapping("/pix")
public class PixCad {
    @Autowired
    private Cadpix cadpix;
    public Cadpix getCadpix() {
        return cadpix;
    }
    public void setCadpix(Cadpix cadpix) {
        this.cadpix = cadpix;
    }
    @PostMapping
    public ResponseEntity<String> incluir(@RequestBody Pix pix){
        if(pix.getTipoChave().isBlank()){
            return new ResponseEntity<>("Chave inválida", HttpStatus.BAD_REQUEST);
        }else{
            HttpStatus estado = ValidaChave.valchave(pix);
            if (estado.value()!= 400 && ValidaBanco.validaAgencia(pix.getAgencia()) && ValidaBanco.validaConta(pix.getConta())){
                    cadpix.save(pix);
                    return new ResponseEntity<>("Cadastrado com sucesso!", HttpStatus.CREATED);
                }else{
                    return new ResponseEntity<>("Cadastro não aceito", HttpStatus.BAD_REQUEST);
                }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(@PathVariable UUID id, @RequestBody Pix pix) {
        Pix pix2 = cadpix.findById(id).orElseThrow();
        if(pix.getTipoChave().equals(pix2.getTipoChave())){
            if(pix.getTipoChave().isBlank()){
                return new ResponseEntity<>("Chave inválida", HttpStatus.BAD_REQUEST);
            }else{
                HttpStatus estado = ValidaChave.valchave(pix);
                if (estado.value()!= 400 && ValidaBanco.validaAgencia(pix.getAgencia()) && ValidaBanco.validaConta(pix.getConta())){
                        cadpix.save(pix);
                        return new ResponseEntity<>("Alterado com sucesso!", HttpStatus.OK);
                    }else{
                        return new ResponseEntity<>("Dados incorretos:", HttpStatus.BAD_REQUEST);
                    }
            }
        }else{
            return new ResponseEntity<>("Chaves não pode ser alterada!", HttpStatus.BAD_REQUEST);
        }
        
    }

    @GetMapping
    public List<Pix> listar(){
        return cadpix.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pix> ler(@PathVariable UUID id) {
        return cadpix.findById(id);
    }


}

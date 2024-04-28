package br.com.itau.pix.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.itau.pix.modelo.Pix;
import br.com.itau.pix.repositorio.Cadpix;
import br.com.itau.pix.validadores.ValidaBanco;
import br.com.itau.pix.validadores.ValidadorCPF;
import br.com.itau.pix.validadores.ValidadorCnpj;
import br.com.itau.pix.validadores.ValidadorTelefone;



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
        if(pix.getTipoChave().equals("CPF")){
            String cpf = pix.getValorChave();
            if(!ValidadorCPF.isCPF(cpf)){
                return new ResponseEntity<>("CPF inválido", HttpStatus.BAD_REQUEST);
            }
        }
    }
    @GetMapping
    public List<Pix> listar(){
        return cadpix.findAll();
    }
    @PutMapping
    public ResponseEntity<String> alterar(@RequestBody Pix pix) {
        cadpix.save(pix);
        return new ResponseEntity<>(HttpStatus.CREATED);
        
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        cadpix.deleteById(id);
    }
    @GetMapping("/{id}")
    public Optional<Pix> ler(@PathVariable UUID id) {
        return cadpix.findById(id);
    }
}
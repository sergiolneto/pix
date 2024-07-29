package br.com.itau.pix.validadores;

import org.springframework.http.HttpStatus;

import br.com.itau.pix.modelo.Pix;

public class ValidaChave {

    public static HttpStatus valchave(Pix pix){
        switch (pix.getTipoChave()) {
                case "CPF":
                    String cpf = pix.getValorChave();
                    if(!ValidadorCPF.isCPF(cpf))
                        return HttpStatus.BAD_REQUEST;
                    break;
                case "CNPJ":
                    String cnpj = pix.getValorChave();
                    if(!ValidadorCnpj.validaCnpj(cnpj))
                        return HttpStatus.BAD_REQUEST;
                break;
                case "TELEFONE":
                String tel = pix.getValorChave();
                if (!ValidadorTelefone.valida(tel))
                    return HttpStatus.BAD_REQUEST;
                    break;
                default:
                return HttpStatus.BAD_REQUEST;
            }
            return HttpStatus.CREATED;
        
    }
}
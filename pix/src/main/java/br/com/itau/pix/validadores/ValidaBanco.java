package br.com.itau.pix.validadores;

public class ValidaBanco {
    public static boolean validaAgencia(String agencia) {
        return agencia.matches("\\d{4}");
    }
    public static boolean validaConta(String cc){
        return cc.matches("\\d{4,8}");
    }

}

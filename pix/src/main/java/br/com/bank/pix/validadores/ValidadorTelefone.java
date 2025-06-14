package br.com.bank.pix.validadores;

import java.util.regex.Pattern;

public class ValidadorTelefone {

    private static final Pattern PADRAO_TELEFONE = Pattern.compile(
            "^\\++[1-9]{1,3}\\s?\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$");

    public static boolean valida(String telefone) {
        return PADRAO_TELEFONE.matcher(telefone).matches();
    }
}

package br.com.itau.pix.validadores;

public class ValidadorCnpj {
    public static boolean validaCnpj(String cnpj) {
        if (cnpj == null || cnpj.length() != 14)
            return false;

        try {
            Long.parseLong(cnpj);
        } catch (NumberFormatException e) {
            return false;
        }

        int soma = 0;

        char[] chr_cnpj = cnpj.toCharArray();
        for (int i = 0; i < 4; i++)
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
        for (int i = 0; i < 8; i++)
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
        if (soma % 11 == 0 || soma % 11 == 1)
            chr_cnpj[12] = '0';
        else
            chr_cnpj[12] = (char) ((11 - soma % 11) + 48);
        soma = 0;
        for (int i = 0; i < 5; i++)
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
        for (int i = 0; i < 8; i++)
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
        if (soma % 11 == 0 || soma % 11 == 1)
            chr_cnpj[13] = '0';
        else
            chr_cnpj[13] = (char) ((11 - soma % 11) + 48);
        if ((cnpj.charAt(12) != chr_cnpj[12]) || (cnpj.charAt(13) != chr_cnpj[13]))
            return false;
        return true;
    }
}

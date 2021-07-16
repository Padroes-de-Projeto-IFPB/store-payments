package br.edu.ifpb.padroes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByPix implements Payment {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private Pix pix;

    @Override
    public boolean pay(int amount) {
        if (pix != null && pix.getAmount() >= amount) {
            System.out.println("Pagando " + amount + " usando PIX.");
            pix.setAmount(pix.getAmount() - amount);
            return true;
        } else {
            System.out.println("Falha ao pagar usando PIX");
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Forneça o tipo da sua chave pix (CPF, TELEFONE, CNPJ, EMAIL): ");
            Pix.CodeType codeType = Pix.CodeType.valueOf(READER.readLine());
            System.out.print("Forneça a chave PIX: ");
            String code = READER.readLine();
            pix = new Pix(code, codeType);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

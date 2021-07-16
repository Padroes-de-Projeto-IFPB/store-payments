package br.edu.ifpb.padroes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements Payment {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    @Override
    public boolean pay(int amount) {
        if (card != null && card.getAmount() >= amount) {
            System.out.println("Pagando " + amount + " usando cartão de crédito.");
            card.setAmount(card.getAmount() - amount);
            return true;
        } else {
            System.out.println("Falha ao pagar usando cartão de crédito");
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Digite o número do cartão: ");
            String number = READER.readLine();
            System.out.print("Digite a data de expiração 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Digite o código de segurança: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);

            // Validate credit card number...

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

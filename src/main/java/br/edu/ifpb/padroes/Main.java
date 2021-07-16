package br.edu.ifpb.padroes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Integer> products = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static Payment payment;
    static {
        products.put(1, 4_400);
        products.put(2, 10_000);
        products.put(3, 25_000);
        products.put(4, 3_000);
        products.put(5, 3_500);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;
            do {
                System.out.print("Selecione um produto:" + "\n" +
                        "1 - IPhone (R$ 4.400,00)" + "\n" +
                        "2 - Macbook Air M1 (R$ 10.000,00)" + "\n" +
                        "3 - Macbook Pro (R$ 25.000,00)" + "\n" +
                        "4 - IPad (R$ 3.000,00)" + "\n" +
                        "5 - Apple Watch (R$ 3.500,00)" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = products.get(choice);
                System.out.print("Quantidade: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Deseja continuar a selecionar produtos? S/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("S"));

            if (payment == null) {
                System.out.println("Selecione um método de pagamento:" + "\n" +
                        "1 - Pix" + "\n" +
                        "2 - Cartão de Crédito");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    payment = new PayByPix();
                } else {
                    payment = new PayByCreditCard();
                }
            }

            order.processOrder(payment);

            System.out.print("Deseja pagar " + order.getTotalCost() + " agora ou continuar a comprar? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (payment.pay(order.getTotalCost())) {
                    System.out.println("Pagamento feito com sucesso!");
                } else {
                    System.out.println("Falha ao realizar pagamento! Confira seus dados!");
                }
                order.setClosed();
            }

        }

    }

}

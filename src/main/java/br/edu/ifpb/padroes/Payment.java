package br.edu.ifpb.padroes;

public interface Payment {

    boolean pay(int amount);
    void collectPaymentDetails();

}

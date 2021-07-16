package br.edu.ifpb.padroes;

public class Pix {
    private int amount;
    private String code;
    private CodeType codeType;
    public enum CodeType { CPF, TELEFONE, CNPJ, EMAIL }

    public Pix(String code, CodeType codeType) {
        this.amount = 5_500;
        this.code = code;
        this.codeType = codeType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeType getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }
}

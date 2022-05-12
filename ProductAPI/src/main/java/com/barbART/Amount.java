package com.barbART;

public class Amount {
    private Double amount;
    private String currency;

    public Amount(Double amount, String currency) {
        this.setAmount(amount);
        this.setCurrency(currency);
    }

    public Amount(){}

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
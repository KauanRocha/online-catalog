package com.example.online.catalog.sales.application.core.domain.order;

import java.util.List;

public class Billing {

    private List<Transaction> transactions;

    private List<Variation> variations;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }
}

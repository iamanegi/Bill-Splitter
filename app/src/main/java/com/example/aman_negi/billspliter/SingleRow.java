package com.example.aman_negi.billspliter;

public class SingleRow {
    private String name, spend, gt;

    public SingleRow(String name, float spend, float gt) {
        this.name = name;
        this.spend = String.valueOf(spend);
        this.gt = String.valueOf(gt);
    }

    public String getName() {
        return name;
    }

    public String getSpend() {
        return spend;
    }

    public String getGt() {
        return gt;
    }
}

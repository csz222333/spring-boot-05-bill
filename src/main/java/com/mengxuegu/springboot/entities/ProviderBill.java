package com.mengxuegu.springboot.entities;

public class ProviderBill extends Bill{




    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }



    @Override
    public String toString() {

        return "ProviderBill{" +
                "providerName='" + providerName + '\'' +
                '}'+super.toString();
    }
}

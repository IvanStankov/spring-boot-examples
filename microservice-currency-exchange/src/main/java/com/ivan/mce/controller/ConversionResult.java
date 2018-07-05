package com.ivan.mce.controller;

import java.math.BigDecimal;

public class ConversionResult {

    private BigDecimal quantity;
    private BigDecimal conversionMultiply;
    private BigDecimal totalCalculatedAmount;

    public ConversionResult(BigDecimal quantity, BigDecimal conversionMultiply, BigDecimal totalCalculatedAmount) {
        this.quantity = quantity;
        this.conversionMultiply = conversionMultiply;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConversionMultiply() {
        return conversionMultiply;
    }

    public void setConversionMultiply(BigDecimal conversionMultiply) {
        this.conversionMultiply = conversionMultiply;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}

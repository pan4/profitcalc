package profitcalculator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {
    private double rub;
    private double usd;

    public double getRub() {
        return rub;
    }

    public void setRub(double rub) {
        this.rub = rub;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }
}
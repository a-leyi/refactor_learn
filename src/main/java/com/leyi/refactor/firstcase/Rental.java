package com.leyi.refactor.firstcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    private Movie movie;

    private int daysRented;

    public double getCharge() {
        double thisAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                thisAmount += 2;
                if (getDaysRented() > 2) thisAmount += (getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> thisAmount += getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                thisAmount += 1.5;
                if (getDaysRented() > 3) thisAmount += (getDaysRented() - 3) * 1.5;
            }
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}

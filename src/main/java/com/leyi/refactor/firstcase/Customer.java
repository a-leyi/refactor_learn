package com.leyi.refactor.firstcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Enumeration;
import java.util.Vector;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public String statement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        return "Rental Record for " + getName() + "\n" + getAllTitle(rentals) +
                "Amount owed is " + getTotalCharge() + "\n" +
                "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
    }

    private StringBuilder getAllTitle(Enumeration<Rental> rentals) {
        StringBuilder result = new StringBuilder();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}

package com.example;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class BillCalculatorBean {

    @PersistenceContext
    private EntityManager em;

    public double calculateBill(int units) {
        double billAmount;
        if (units <= 100) {
            billAmount = units * 1.20;
        } else if (units <= 300) {
            billAmount = 100 * 1.20 + (units - 100) * 2;
        } else {
            billAmount = 100 * 1.20 + 200 * 2 + (units - 300) * 3;
        }
        
        ElectricityBill bill = new ElectricityBill(units, billAmount);
        em.persist(bill);
        
        return billAmount;
    }
}
package org.javaacademy.taxi;

import java.math.BigDecimal;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class Car {
    @Value("${car.dayRate}")
    private int dayRate;
    @Value("${car.nightRate}")
    private int nightRate;
    @Getter
    private String carNumber;
    @Getter
    private BigDecimal earnedMoney = BigDecimal.ZERO;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal takeOrder(Customer customer, boolean isDay) throws Exception {
        int rate = nightRate;
        int distance = 0;

        if (isDay) {
            rate = dayRate;
        }
        for (Tariff tariff : Tariff.values()) {
            if (tariff.getName().equals(customer.getAddress())) {
                distance = tariff.getDistance();
            }
        }
        if (distance == 0) {
            throw new Exception("Адреса нет в базе");
        }
        BigDecimal orderEarnedMoney = BigDecimal.valueOf((rate * distance) / 2);
        earnedMoney = earnedMoney.add(orderEarnedMoney);
        return orderEarnedMoney;
    }
}
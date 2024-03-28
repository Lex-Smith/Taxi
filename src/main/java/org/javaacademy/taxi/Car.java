package org.javaacademy.taxi;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
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
//    private Map<String, Integer> tariffSchedule = Map.of(
//            "Березовая роща", 10,
//            "Кандикюля", 4,
//            "Строитель", 12
//    );

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    /*
    public void takeOrderMap(Customer customer, boolean isDay) throws Exception {
        BigDecimal orderCost;
        BigDecimal rate = nightRate;
        if (isDay) {
            rate = dayRate;
        }
        if (tariffSchedule.containsKey(customer.getAddress())) {
            orderCost = rate.multiply(BigDecimal
                    .valueOf(tariffSchedule.get(customer.getAddress())));
        } else {
            throw new Exception("Адреса нет в базе");
        }
        earnedMoney = orderCost.divide(BigDecimal.valueOf(2), 2);
    }

     */

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
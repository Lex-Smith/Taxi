package org.javaacademy.taxi;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public abstract class TaxiStation {
    @Value("${taxiStation.name}")
    private String name;
    private BigDecimal earnedAmount = BigDecimal.ZERO;
    private List<Car> cars;
    private int ordersCount = 0;

    public TaxiStation(List<Car> cars) {
        this.cars = cars;
    }

    public void acceptOrder(Customer customer, Boolean isDay) {
        try {
            Car car = cars.get(ordersCount);
            earnedAmount = earnedAmount.add(car.takeOrder(customer, isDay));
        } catch (Exception e) {
        }
        ordersCount++;
        if (ordersCount >= cars.size()) {
            ordersCount = 0;
        }
    }

    public void summarize() {
        System.out.printf("Имя таксопарка: %s\n", name);
        System.out.println("Заработано: " + earnedAmount);
        cars.forEach(car -> System.out.printf("Водитель машины %s заработал: %s\n",
                car.getCarNumber(), car.getEarnedMoney()));
    }
}
package org.javaacademy.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
        Customer customer1 = new Customer("Кандикюля");
        Customer customer2 = new Customer("Строитель");
        Customer customer3 = new Customer("Березовая роща");
        Customer customer4 = new Customer("Ломоносов");
        TaxiStation taxiStation = context.getBean(TaxiStation.class);
        taxiStation.acceptOrder(customer1, true);
        taxiStation.acceptOrder(customer2, true);
        taxiStation.acceptOrder(customer3, false);
        taxiStation.acceptOrder(customer4, false);
        taxiStation.summarize();
    }
}
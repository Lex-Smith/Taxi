package org.javaacademy.taxi;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("bluz")
public class BluzTaxiStationConfig {

    @Bean
    public Car car1() {
        return new Car("В001ВВ198");
    }
    
    @Bean
    public Car car2() {
        return new Car("В002ВВ198");
    }

    @Bean
    public BluzTaxiStation bluzTaxiStation() {
        return new BluzTaxiStation(Arrays.asList(car1(), car2()));
    }
}
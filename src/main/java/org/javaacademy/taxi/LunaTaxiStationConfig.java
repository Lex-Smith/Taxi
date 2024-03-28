package org.javaacademy.taxi;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("luna")
public class LunaTaxiStationConfig {

    @Bean
    public Car car1() {
        return new Car("M001MM198");
    }

    @Bean
    public Car car2() {
        return new Car("M002MM198");
    }

    @Bean
    public Car car3() {
        return new Car("M003MM198");
    }

    @Bean
    public LunaTaxiStation lunaTaxiStation() {
        return new LunaTaxiStation(Arrays.asList(car1(), car2(), car3()));
    }
}
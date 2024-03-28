package org.javaacademy.taxi;

import java.util.List;
import org.springframework.context.annotation.Profile;

@Profile("luna")
public class LunaTaxiStation extends TaxiStation {
    public LunaTaxiStation(List<Car> cars) {
        super(cars);
    }
}
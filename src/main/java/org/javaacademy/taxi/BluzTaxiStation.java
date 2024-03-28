package org.javaacademy.taxi;

import java.util.List;
import org.springframework.context.annotation.Profile;

@Profile("bluz")
public class BluzTaxiStation extends TaxiStation {
    public BluzTaxiStation(List<Car> cars) {
        super(cars);
    }
}
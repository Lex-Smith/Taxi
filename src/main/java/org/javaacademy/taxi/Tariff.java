package org.javaacademy.taxi;

import lombok.Getter;

@Getter
public enum Tariff {
    BEREZOVAYA_ROSHA("Березовая роща", 10),
    KANDIKJYLA("Кандикюля", 4),
    STROITEL("Строитель", 12);

    private final String name;
    private final int distance;

    Tariff(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
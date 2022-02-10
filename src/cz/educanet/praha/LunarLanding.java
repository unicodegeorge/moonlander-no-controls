package cz.educanet.praha;

import java.util.Objects;

public class LunarLanding {
    private static final int FUEL_POWER = 40;
    private static final int G = 500;

    private final ILanderControls controls;
    private int altitude;
    private int velocity;

    public LunarLanding(ILanderControls controls, int altitude, int velocity) {
        Objects.requireNonNull(controls);
        this.controls = controls;

        if (altitude < 0) throw new IllegalArgumentException("Altitude should be non-negative");
        this.altitude = altitude;

        this.velocity = velocity;
    }

    public int land() {
        int totalFuelBurnt = 0;
        while (true) {
            if (altitude < 10) {
                if (velocity < 50) break;
                else
                    throw new IllegalStateException("Lander crashed at a velocity of:" + velocity + ", keep it under 50 to land safely");
            }

            int fuel = controls.getSecondsOfFuelBurn(altitude, velocity);
            if (fuel < 0) fuel = 0; // TODO throw exception
            totalFuelBurnt += fuel;
            velocity -= (fuel * FUEL_POWER) - G;
            altitude -= velocity;
        }
        return totalFuelBurnt;
    }
}

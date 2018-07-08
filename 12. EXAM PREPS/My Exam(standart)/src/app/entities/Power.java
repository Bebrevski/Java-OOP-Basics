package app.entities;

import app.contracts.SuperPower;
import app.utils.Constants;

public class Power implements SuperPower {

    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints + this.name.length() / 2;
    }

    private void setName(String name) {
        String namePattern = "@[a-zA-Z_]{3,}@";
        if (!name.matches(namePattern)) {
            throw new IllegalArgumentException(Constants.INVALID_SUPER_POWER_NAME);
        }
        this.name = name;
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints < 0D) {
            throw new IllegalArgumentException(Constants.INVALID_POWER_POINTS);
        }
        this.powerPoints = powerPoints;
    }
}

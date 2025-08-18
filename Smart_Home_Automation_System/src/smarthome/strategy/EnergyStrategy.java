package smarthome.strategy;

import smarthome.controller.HomeController;

public interface EnergyStrategy {
    String name();
    void apply(HomeController controller);
}
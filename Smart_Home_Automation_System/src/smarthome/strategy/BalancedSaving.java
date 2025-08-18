package smarthome.strategy;

import smarthome.controller.HomeController;

public class BalancedSaving implements EnergyStrategy {
    @Override public String name() { return "BalancedSaving"; }

    @Override
    public void apply(HomeController controller) {
        System.out.println("\nApplying strategy: " + name());
        controller.broadcast("LIGHT:DIM:50");
        controller.broadcast("THERMOSTAT:SET:24");
        controller.broadcast("CAMERA:ARM");
    }
}
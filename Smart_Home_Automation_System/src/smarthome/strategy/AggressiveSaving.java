package smarthome.strategy;

import smarthome.controller.HomeController;

public class AggressiveSaving implements EnergyStrategy {
    @Override public String name() { return "AggressiveSaving"; }

    @Override
    public void apply(HomeController controller) {
        System.out.println("\nApplying strategy: " + name());
        controller.broadcast("LIGHT:OFF");
        controller.broadcast("THERMOSTAT:SET:26");
        controller.broadcast("CAMERA:ARM");
    }
}
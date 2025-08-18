package smarthome.factory;

import smarthome.device.*;

public class SamsungFactory implements BrandFactory {
    @Override public Light createLight() { return new Light("Samsung Smart Bulb"); }
    @Override public Thermostat createThermostat() { return new Thermostat("Samsung Thermostat"); }
    @Override public SecurityCamera createSecurityCamera() { return new SecurityCamera("Samsung Smart Cam"); }
}
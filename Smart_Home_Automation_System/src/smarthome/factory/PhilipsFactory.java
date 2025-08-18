package smarthome.factory;

import smarthome.device.*;

public class PhilipsFactory implements BrandFactory {
    @Override public Light createLight() { return new Light("Philips Hue Light"); }
    @Override public Thermostat createThermostat() { return new Thermostat("Philips Thermostat"); }
    @Override public SecurityCamera createSecurityCamera() { return new SecurityCamera("Philips Secure Cam"); }
}

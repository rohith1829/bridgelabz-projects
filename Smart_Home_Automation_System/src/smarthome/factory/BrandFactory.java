package smarthome.factory;

import smarthome.device.*;

public interface BrandFactory {
    Light createLight();
    Thermostat createThermostat();
    SecurityCamera createSecurityCamera();
}
package smarthome.factory;

import smarthome.device.*;

public class DeviceFactory {
    public Device create(String type, String name) {
        return switch (type.toLowerCase()) {
            case "light" -> new Light(name);
            case "thermostat" -> new Thermostat(name);
            case "camera", "securitycamera" -> new SecurityCamera(name);
            default -> throw new IllegalArgumentException("Unknown device type: " + type);
        };
    }
}

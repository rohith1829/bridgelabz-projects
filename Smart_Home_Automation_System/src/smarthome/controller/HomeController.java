package smarthome.controller;

import smarthome.device.Device;
import smarthome.scene.Scene;
import smarthome.scene.SceneManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeController {
    private static volatile HomeController instance;
    private final List<Device> devices = new ArrayList<>();
    private final SceneManager sceneManager = new SceneManager();

    private HomeController() {}

    public static HomeController getInstance() {
        if (instance == null) {
            synchronized (HomeController.class) {
                if (instance == null) instance = new HomeController();
            }
        }
        return instance;
    }

    public void registerDevice(Device device) {
        if (device == null) return;
        devices.add(device);
        sceneManager.register(device); // Observer subscription
        System.out.println("Registered device: " + device.getName());
    }

    public List<Device> getDevices() {
        return Collections.unmodifiableList(devices);
    }

    public void broadcast(String command) {
        // Sends a direct command to all devices
        for (Device d : devices) {
            d.onCommand(command);
        }
    }

    public void applyScene(Scene scene) {
        sceneManager.applyScene(scene);
    }
}

package smarthome.scene;

import smarthome.device.Device;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {
    private final List<Device> observers = new ArrayList<>();

    public void register(Device d) { if (d != null) observers.add(d); }
    public void unregister(Device d) { observers.remove(d); }

    public void applyScene(Scene scene) {
        System.out.println("\nApplying scene: " + scene.getName());
        for (Device d : observers) {
            d.onScene(scene);
        }
    }
}

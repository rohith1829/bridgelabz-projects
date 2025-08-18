package smarthome.device;

import smarthome.scene.Scene;

public interface Device {
    String getName();

    // Observer callback for scenes
    default void onScene(Scene scene) {
        for (String cmd : scene.getCommands()) {
            onCommand(cmd);
        }
    }
 // Direct command interface
    void onCommand(String command);
}
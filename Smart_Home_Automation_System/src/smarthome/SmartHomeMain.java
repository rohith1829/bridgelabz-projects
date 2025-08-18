package smarthome;

import smarthome.controller.HomeController;
import smarthome.device.Device;
import smarthome.factory.*;
import smarthome.scene.Scene;
import smarthome.strategy.*;

import java.util.Scanner;

public class SmartHomeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HomeController controller = HomeController.getInstance();

        System.out.println("=== Smart Home Automation System ===");

        // Brand choice (Abstract Factory)
        System.out.println("\nChoose Brand Family:");
        System.out.println("1. Philips");
        System.out.println("2. Samsung");
        System.out.print("Enter choice: ");
        int brandChoice = sc.nextInt();
        sc.nextLine(); // clear newline

        BrandFactory brand;
        if (brandChoice == 1) {
            brand = new PhilipsFactory();
        } else if (brandChoice == 2) {
            brand = new SamsungFactory();
        } else {
            System.out.println("Invalid brand. Defaulting to Philips.");
            brand = new PhilipsFactory();
        }

        // Register default devices
        Device light = brand.createLight();
        Device thermostat = brand.createThermostat();
        Device camera = brand.createSecurityCamera();

        controller.registerDevice(light);
        controller.registerDevice(thermostat);
        controller.registerDevice(camera);

        // Extra devices (Simple Factory)
        DeviceFactory factory = new DeviceFactory();
        while (true) {
            System.out.print("\nAdd extra device? (light/thermostat/camera or 'done'): ");
            String type = sc.nextLine().toLowerCase();
            if (type.equals("done")) break;

            try {
                System.out.print("Enter device name: ");
                String name = sc.nextLine();
                Device d = factory.create(type, name);
                controller.registerDevice(d);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid device type.");
            }
        }

        // Scene choice (Builder + Observer)
        System.out.println("\nChoose Scene:");
        System.out.println("1. Morning Routine");
        System.out.println("2. Night Mode");
        System.out.print("Enter choice: ");
        int sceneChoice = sc.nextInt();

        Scene scene;
        if (sceneChoice == 1) {
            scene = new Scene.Builder()
                    .name("MorningRoutine")
                    .addCommand("LIGHT:ON")
                    .addCommand("THERMOSTAT:SET:22")
                    .addCommand("CAMERA:DISARM")
                    .build();
        } else {
            scene = new Scene.Builder()
                    .name("NightMode")
                    .addCommand("LIGHT:DIM:20")
                    .addCommand("THERMOSTAT:SET:23")
                    .addCommand("CAMERA:ARM")
                    .build();
        }
        controller.applyScene(scene);

        // Strategy choice (Strategy Pattern)
        System.out.println("\nChoose Energy Saving Strategy:");
        System.out.println("1. Balanced Saving");
        System.out.println("2. Aggressive Saving");
        System.out.print("Enter choice: ");
        int stratChoice = sc.nextInt();

        EnergyStrategy strategy;
        if (stratChoice == 1) {
            strategy = new BalancedSaving();
        } else {
            strategy = new AggressiveSaving();
        }
        strategy.apply(controller);

        System.out.println("\n=== Smart Home setup complete! ===");
        sc.close();
    }
}

package smarthome.device;

public class Thermostat implements Device {
    private final String name;
    private int temperature = 24; // default Celsius

    public Thermostat(String name) {
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void onCommand(String command) {
        if (command.startsWith("THERMOSTAT:SET:")) {
            String[] parts = command.split(":");
            if (parts.length == 3) {
                try {
                    temperature = Integer.parseInt(parts[2]);
                    System.out.println(name + " -> SET " + temperature + "°C");
                } catch (NumberFormatException ignored) {}
            }
        }
    }
}
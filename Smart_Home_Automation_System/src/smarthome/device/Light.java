package smarthome.device;

public class Light implements Device {
    private final String name;
    private boolean on = false;
    private int level = 100; // percentage

    public Light(String name) {
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void onCommand(String command) {
        if ("LIGHT:ON".equalsIgnoreCase(command)) {
            on = true;
            level = 100;
            System.out.println(name + " -> ON (100%)");
        } else if ("LIGHT:OFF".equalsIgnoreCase(command)) {
            on = false;
            System.out.println(name + " -> OFF");
        } else if (command.startsWith("LIGHT:DIM:")) {
            String[] parts = command.split(":");
            if (parts.length == 3) {
                try {
                    level = Integer.parseInt(parts[2]);
                    on = level > 0;
                    System.out.println(name + " -> DIM(" + level + "%)");
                } catch (NumberFormatException ignored) {}
            }
        }
    }
}
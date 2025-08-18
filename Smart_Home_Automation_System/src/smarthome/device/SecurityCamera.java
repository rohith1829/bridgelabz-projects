package smarthome.device;

public class SecurityCamera implements Device {
    private final String name;
    private boolean armed = false;

    public SecurityCamera(String name) {
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void onCommand(String command) {
        if ("CAMERA:ARM".equalsIgnoreCase(command)) {
            armed = true;
            System.out.println(name + " -> ARMED");
        } else if ("CAMERA:DISARM".equalsIgnoreCase(command)) {
            armed = false;
            System.out.println(name + " -> DISARMED");
        }
    }
}
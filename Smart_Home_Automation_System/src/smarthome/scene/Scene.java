package smarthome.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scene {
    private final String name;
    private final List<String> commands;

    private Scene(Builder b) {
        this.name = b.name;
        this.commands = List.copyOf(b.commands);
    }

    public String getName() { return name; }
    public List<String> getCommands() { return Collections.unmodifiableList(commands); }

    public static class Builder {
        private String name = "Unnamed Scene";
        private final List<String> commands = new ArrayList<>();

        public Builder name(String name) { this.name = name; return this; }
        public Builder addCommand(String command) { this.commands.add(command); return this; }
        public Scene build() { return new Scene(this); }
    }

    @Override public String toString() { return "Scene{" + name + ", commands=" + commands + '}'; }
}
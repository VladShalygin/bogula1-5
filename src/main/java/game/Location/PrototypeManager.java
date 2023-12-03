package main.java.game.Location;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {
    private static PrototypeManager instance;

    private Map<String, Location> locationMap = new HashMap<>();

    private PrototypeManager() {
        // Приватный конструктор, чтобы предотвратить создание экземпляра извне класса.
        // Инициализация локаций
        locationMap.put("forest", new Forest());
        locationMap.put("castle", new Castle());
    }

    public static PrototypeManager getInstance() {
        if (instance == null) {
            instance = new PrototypeManager();
        }
        return instance;
    }

    public void addLocation(String key, Location location) {
        locationMap.put(key, location);
    }

    public Location getLocation(String key) {
        Location location = locationMap.get(key);
        if (location != null) {
            return location.clone();
        }
        return null;
    }
}
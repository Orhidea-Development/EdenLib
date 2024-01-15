package dev.orhidea.edenlib.handler.fallback;

import dev.orhidea.edenlib.handler.IDataHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FallbackDataHandler implements IDataHandler {

    @Override
    public boolean isInValidWorld(Location location) {
        return true;
    }

    @Override
    public String getEntityHandler(Location location) {
        return location.getWorld().getName();
    }

    @Override
    public String getEntityHandler(String input) {
        return null;
    }

    @Override
    public String getEntityHandler(Player player) {
        return player.getUniqueId().toString();
    }

    @Override
    public boolean canAccess(Player player, Location location) {
        return true;
    }

    @Override
    public boolean isSameLand(Location location1, Location location2) {
        return location1.getWorld().equals(location2.getWorld());
    }

    @Override
    public List<String> getListOfEntityIds() {
        return new ArrayList<>();
    }

    @Override
    public List<Player> getListOfOnlinePlayers(String entityId) {
        return new ArrayList<>(Bukkit.getOnlinePlayers());
    }
}

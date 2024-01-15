package dev.orhidea.edenlib.integration.placeholderapi;

import com.massivecraft.massivecore.Engine;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public abstract class PapiExpansionEngine extends Engine {

    private EdenExpansion edenExpansion;

    public abstract EdenExpansion getInstance();

    public void register() {
        this.edenExpansion = getInstance();
        this.edenExpansion.register();
    }

    public void unregister() {
        if(this.edenExpansion != null) {
            this.edenExpansion.unregister();
        }
    }

    public String setPlaceholders(Player player, String line) {
        return PlaceholderAPI.setPlaceholders(player, line);
    }

}

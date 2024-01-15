package dev.orhidea.edenlib.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface IGuiBuilder {

    Inventory build(Player player, String... replacements);
    Inventory build(String... replacements);

}

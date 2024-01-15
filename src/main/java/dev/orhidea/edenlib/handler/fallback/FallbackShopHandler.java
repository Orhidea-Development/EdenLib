package dev.orhidea.edenlib.handler.fallback;

import dev.orhidea.edenlib.handler.IShopHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FallbackShopHandler implements IShopHandler {

    @Override
    public double getSellPrice(ItemStack itemStack, Player player, long amount) {
        return 0;
    }
}

package dev.orhidea.edenlib.handler.fallback;

import dev.orhidea.edenlib.EdenLib;
import dev.orhidea.edenlib.handler.ITokenHandler;
import org.bukkit.entity.Player;

public class FallbackTokenHandler implements ITokenHandler {

    @Override
    public long getTokenBalance(Player player) {
        return 0;
    }

    @Override
    public void addTokens(Player player, long amount) {
        EdenLib.get().log("Cannot add tokens as system is only using fallback.");
    }

    @Override
    public void removeTokens(Player player, long amount) {
        EdenLib.get().log("Cannot remove tokens as system is only using fallback.");
    }

    @Override
    public boolean hasTokens(Player player, long amount) {
        return false;
    }
}

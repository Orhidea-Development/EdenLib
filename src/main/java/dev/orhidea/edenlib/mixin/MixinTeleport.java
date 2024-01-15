package dev.orhidea.edenlib.mixin;

import com.massivecraft.massivecore.mixin.Mixin;
import com.massivecraft.massivecore.mixin.MixinMessage;
import dev.orhidea.edenlib.engine.EngineTeleport;
import dev.orhidea.edenlib.entity.Conf;
import dev.orhidea.edenlib.event.PlayerTeleportLibEvent;
import dev.orhidea.edenlib.task.TaskTeleportTimer;
import dev.orhidea.edenlib.util.LibUtil;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
public class MixinTeleport extends Mixin {

    // -------------------------------------------- //
    // INSTANCE & CONSTRUCT
    // -------------------------------------------- //

    private final static MixinTeleport d = new MixinTeleport();
    private static MixinTeleport i = d;
    public static MixinTeleport get() { return i; }

    // -------------------------------------------- //
    // METHODS
    // -------------------------------------------- //

    public static void teleportPlayer(Player player, Location location) {
        teleportPlayer(player, location, null);
    }

    public static void teleportPlayer(Player player, Location location, String locationDescription) {
        // eject passengers and unmount before transport
        player.eject();
        Entity vehicle = player.getVehicle();

        if (vehicle != null) vehicle.eject();

        // Do the teleport

        EngineTeleport.get().addUserToTeleportBlacklist(player);

        PlayerTeleportLibEvent event = new PlayerTeleportLibEvent(player, location);

        LibUtil.callEvent(event);
        player.teleport(location);

        EngineTeleport.get().removeUserFromTeleportBlacklist(player);

        if(locationDescription == null) {
            MixinMessage.get().msgOne(player, Conf.get().msgTeleporting);
        } else {
            MixinMessage.get().msgOne(player, Conf.get().msgTeleportingNow, locationDescription);
        }
    }

    public static void teleportPlayer(Player player, Location location, int delaySeconds) {
        teleportPlayer(player, location, delaySeconds, null);
    }

    public static void teleportPlayer(Player player, Location location, int delaySeconds, String locationDescription) {
        if(delaySeconds <= 0) {
            teleportPlayer(player, location, locationDescription);
            return;
        }

        long timeInMillis = delaySeconds * 1000L;

        if(locationDescription == null) {
            MixinMessage.get().msgOne(player, Conf.get().msgTeleportingDelayNoObject, LibUtil.getTimeDescription(timeInMillis));
        } else {
            MixinMessage.get().msgOne(player, Conf.get().msgTeleportingDelayObject, locationDescription, LibUtil.getTimeDescription(timeInMillis));
        }

        TaskTeleportTimer.get().addUserToMap(player.getUniqueId(), (System.currentTimeMillis() + timeInMillis), callback -> {
            if(callback) {
                teleportPlayer(player, location, locationDescription);
            } else {
                MixinMessage.get().msgOne(player, Conf.get().msgTeleportingCancelled);
            }
        });
    }
}

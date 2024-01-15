package dev.orhidea.edenlib;

import com.massivecraft.massivecore.MassivePlugin;
import dev.orhidea.edenlib.coll.ConfColl;
import dev.orhidea.edenlib.engine.*;
import dev.orhidea.edenlib.handler.*;
import dev.orhidea.edenlib.handler.fallback.*;
import dev.orhidea.edenlib.handler.provider.*;
import dev.orhidea.edenlib.mixin.MixinInventory;
import dev.orhidea.edenlib.mixin.MixinTeleport;
import dev.orhidea.edenlib.nms.*;
import dev.orhidea.edenlib.task.TaskTeleportTimer;

import java.util.logging.Level;
/*

    Original plugin https://github.com/StellarDev-org/GalacticLib

 */
public final class EdenLib extends MassivePlugin  implements IDataHandlerProvider, IShopHandlerProvider, ITokenHandlerProvider, ISpawnerHandlerProvider, IPermissionHandlerProvider {

    private static EdenLib i;
    public static EdenLib get() { return i; }

    public EdenLib() {
        i = this;
    }

    private final ISpawnerHandler fallbackSpawnerHandler = new FallbackSpawnerHandler();
    private final ITokenHandler fallbackTokenHandler = new FallbackTokenHandler();
    private final IDataHandler fallbackDataHandler = new FallbackDataHandler();
    private final IShopHandler fallbackShopHandler = new FallbackShopHandler();
    private final IPermissionHandler fallbackPermissionHandler = new FallbackPermissionHandler();

    private ISpawnerHandler spawnerHandler;
    private ITokenHandler tokenHandler;
    private IDataHandler dataHandler;
    private IShopHandler shopHandler;
    private IPermissionHandler permissionHandler;

    @Override
    public void onEnableInner() {
        this.activate(
                ConfColl.class,

                EngineAnvil.class,
                EngineArmorEquip.class,
                EngineGui.class,
                EngineTeleport.class,

                MixinInventory.class,
                MixinTeleport.class,

                NmsArmorStandPacket.class,
                NmsChestPacket.class,
                NmsPing.class,
                NmsSkullTexture.class,
                NmsTps.class,

                TaskTeleportTimer.class
        );
    }
    @Override
    public IShopHandler getShopHandler() { return this.shopHandler == null? this.fallbackShopHandler : this.shopHandler; }
    @Override
    public IDataHandler getDataHandler() { return this.dataHandler == null? this.fallbackDataHandler : this.dataHandler; }
    @Override
    public ITokenHandler getTokenHandler() { return this.tokenHandler == null? this.fallbackTokenHandler : this.tokenHandler; }
    @Override
    public ISpawnerHandler getSpawnerHandler() { return this.spawnerHandler == null? this.fallbackSpawnerHandler : this.spawnerHandler; }
    @Override
    public IPermissionHandler getPermissionHandler() { return this.permissionHandler == null? this.fallbackPermissionHandler : this.permissionHandler; }

    public void registerShopHandler(IShopHandler shopHandler) {
        if(this.shopHandler != null) {
            EdenLib.get().log(Level.SEVERE, "An issue occurred when registering the new shop handler '" + shopHandler.getClass().getSimpleName() + "', as a shop handler is already set.");
            return;
        }

        EdenLib.get().log("Shop handler has now been set to " + shopHandler.getClass().getSimpleName() + ".");
        this.shopHandler = shopHandler;
    }
    public void registerDataHandler(IDataHandler dataHandler) {
        if(this.dataHandler != null) {
            EdenLib.get().log(Level.SEVERE, "An issue occurred when registering the new data handler '" + dataHandler.getClass().getSimpleName() + "', as a data handler is already set.");
            return;
        }

        EdenLib.get().log("Data handler has now been set to " + dataHandler.getClass().getSimpleName() + ".");
        this.dataHandler = dataHandler;
    }
    public void registerTokenHandler(ITokenHandler tokenHandler) {
        if(this.tokenHandler != null) {
            EdenLib.get().log(Level.SEVERE, "An issue occurred when registering the new token handler '" + tokenHandler.getClass().getSimpleName() + "', as a token handler is already set.");
            return;
        }

        EdenLib.get().log("Token handler has now been set to " + tokenHandler.getClass().getSimpleName() + ".");
        this.tokenHandler = tokenHandler;
    }
    public void registerSpawnerHandler(ISpawnerHandler spawnerHandler) {
        if(this.spawnerHandler != null) {
            EdenLib.get().log(Level.SEVERE, "An issue occurred when registering the new spawner handler '" + spawnerHandler.getClass().getSimpleName() + "', as a spawner handler is already set.");
            return;
        }

        EdenLib.get().log("Spawner handler has now been set to " + spawnerHandler.getClass().getSimpleName() + ".");
        this.spawnerHandler = spawnerHandler;
    }
    public void registerPermissionHandler(IPermissionHandler permissionHandler) {
        if(this.permissionHandler != null) {
            EdenLib.get().log(Level.SEVERE, "An issue occurred when registering the new spawner handler '" + permissionHandler.getClass().getSimpleName() + "', as a permission handler is already set.");
            return;
        }

        EdenLib.get().log("Permission handler has now been set to " + permissionHandler.getClass().getSimpleName() + ".");
        this.permissionHandler = permissionHandler;
    }

    @Override
    public boolean isVersionSynchronized() {
        return false;
    }
}

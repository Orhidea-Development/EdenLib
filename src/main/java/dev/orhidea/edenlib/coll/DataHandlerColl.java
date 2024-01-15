package dev.orhidea.edenlib.coll;

import com.massivecraft.massivecore.store.Coll;
import com.massivecraft.massivecore.store.Entity;
import dev.orhidea.edenlib.EdenLib;
import dev.orhidea.edenlib.handler.IDataHandler;
import org.bukkit.Location;

public class DataHandlerColl<T extends Entity<T>> extends Coll<T> {

    public DataHandlerColl(String id) {
        super(id);
    }

    public T getByObject(Object object) {
        return getByObject(object, true);
    }

    public T getByObject(Object object, boolean creative) {
        IDataHandler dataHandler = EdenLib.get().getDataHandler();

        if(dataHandler == null) return null;

        String id = null;

        if(object instanceof Location) {
            return getByLocation((Location) object, creative);
        } else if(object instanceof String) {
            id = (String) object;
        }

        if(id == null) return null;

        return get(id, creative);
    }

    public T getByLocation(Location location) {
        return getByLocation(location, true);
    }

    public T getByLocation(Location location, boolean creative) {
        IDataHandler dataHandler = EdenLib.get().getDataHandler();

        if(dataHandler == null) return null;
        if(!dataHandler.isInValidWorld(location)) return null;

        String id = dataHandler.getEntityHandler(location);

        if(id == null) return null;

        return get(id, creative);
    }

}

package dev.orhidea.edenlib.coll;

import com.massivecraft.massivecore.store.ConfigurationColl;
import dev.orhidea.edenlib.entity.Conf;

public class ConfColl extends ConfigurationColl<Conf> {

    private static final ConfColl i = new ConfColl();
    public static ConfColl get() { return i; }

    private ConfColl() {
        super("edenlib_conf", Conf.class);
    }
}

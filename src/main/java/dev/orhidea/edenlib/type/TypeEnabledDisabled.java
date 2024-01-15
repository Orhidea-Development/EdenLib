package dev.orhidea.edenlib.type;

import com.massivecraft.massivecore.util.Txt;
import dev.orhidea.edenlib.entity.Conf;

public class TypeEnabledDisabled {

    public static String get(boolean bool) {
        return Txt.parse(bool? Conf.get().msgEnabledDisplay : Conf.get().msgDisabledDisplay);
    }

}

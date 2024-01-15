package dev.orhidea.edenlib.type;

import com.massivecraft.massivecore.util.Txt;
import dev.orhidea.edenlib.entity.Conf;

public class TypeTrueFalse {

    public static String get(boolean bool) {
        return Txt.parse(bool? Conf.get().msgTrueDisplay : Conf.get().msgFalseDisplay);
    }
}

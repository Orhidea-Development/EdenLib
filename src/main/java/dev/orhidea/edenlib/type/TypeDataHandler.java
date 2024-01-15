package dev.orhidea.edenlib.type;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.type.TypeAbstract;
import dev.orhidea.edenlib.EdenLib;
import dev.orhidea.edenlib.entity.Conf;
import org.bukkit.command.CommandSender;

import java.util.Collection;

public class TypeDataHandler extends TypeAbstract<String> {

    private static final TypeDataHandler i = new TypeDataHandler();
    public static TypeDataHandler get() { return i; }

    private TypeDataHandler() {
        super(String.class);
    }

    @Override
    public String read(String s, CommandSender commandSender) throws MassiveException {
        String read = EdenLib.get().getDataHandler().getEntityHandler(s);

        if(read == null) {
            throw new MassiveException().addMsg(Conf.get().msgDataHandlerNotFound);
        }

        return read;
    }

    @Override
    public Collection<String> getTabList(CommandSender commandSender, String s) {
        return EdenLib.get().getDataHandler().getListOfEntityIds();
    }
}

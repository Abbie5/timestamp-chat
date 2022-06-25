package cc.abbie.timestamp_chat;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreLaunch implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch(ModContainer mod) {
        AutoConfig.register(Config.class, Toml4jConfigSerializer::new);
    }
}

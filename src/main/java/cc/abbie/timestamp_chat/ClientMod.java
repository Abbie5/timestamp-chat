package cc.abbie.timestamp_chat;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        AutoConfig.register(Config.class, Toml4jConfigSerializer::new);
    }
}

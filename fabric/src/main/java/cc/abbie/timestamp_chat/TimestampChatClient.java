package cc.abbie.timestamp_chat;

import cc.abbie.timestamp_chat.config.Config;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class TimestampChatClient implements ClientModInitializer {
    public static Config CONFIG;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(Config.class, Toml4jConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(Config.class).getConfig();
    }
}

package cc.abbie.timestamp_chat;

import cc.abbie.timestamp_chat.config.Config;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class TimestampChatClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(Config.class, Toml4jConfigSerializer::new);
    }
}

package cc.abbie.timestamp_chat;

import cc.abbie.timestamp_chat.config.Config;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

public class TimestampChatClient {
    public static Config CONFIG;

    public static void init() {
        AutoConfig.register(Config.class, Toml4jConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(Config.class).getConfig();
    }
}

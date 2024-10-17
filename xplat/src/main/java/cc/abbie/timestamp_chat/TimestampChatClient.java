package cc.abbie.timestamp_chat;

import cc.abbie.timestamp_chat.config.Config;
import cc.abbie.timestamp_chat.config.ConfigAutoConfigImpl;
import cc.abbie.timestamp_chat.config.DefaultConfigImpl;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

public class TimestampChatClient {
    public static Config CONFIG;

    public static void init() {
        if (Platform.isClothConfigLoaded()) {
            CONFIG = ConfigAutoConfigImpl.register();
        } else {
            CONFIG = DefaultConfigImpl.DEFAULT;
        }
    }
}

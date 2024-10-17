package cc.abbie.timestamp_chat.client;

import cc.abbie.timestamp_chat.Platform;
import cc.abbie.timestamp_chat.client.config.Config;
import cc.abbie.timestamp_chat.client.config.ConfigAutoConfigImpl;
import cc.abbie.timestamp_chat.client.config.DefaultConfigImpl;

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

package cc.abbie.timestamp_chat.fabric;

import cc.abbie.timestamp_chat.TimestampChatClient;
import net.fabricmc.api.ClientModInitializer;

public class TimestampChatFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TimestampChatClient.init();
    }
}

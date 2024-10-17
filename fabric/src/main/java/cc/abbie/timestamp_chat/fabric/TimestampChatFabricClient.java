package cc.abbie.timestamp_chat.fabric;

import cc.abbie.timestamp_chat.Timestamp;
import cc.abbie.timestamp_chat.TimestampChatClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.Minecraft;

public class TimestampChatFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TimestampChatClient.init();

        ClientReceiveMessageEvents.MODIFY_GAME.register(
                (message, overlay) -> Timestamp.addToMessage(message)
        );

        ClientReceiveMessageEvents.ALLOW_CHAT.register(
                ((message, signedMessage, sender, params, receptionTimestamp) -> {
                    Minecraft.getInstance().gui.getChat().addMessage(
                            Timestamp.addToMessage(message),
                            signedMessage == null ? null : signedMessage.signature(),
                            null
                    );
                    return false;
                })
        );
    }
}

package cc.abbie.timestamp_chat.neoforge.client;

import cc.abbie.timestamp_chat.Platform;
import cc.abbie.timestamp_chat.TimestampChat;
import cc.abbie.timestamp_chat.client.Timestamp;
import cc.abbie.timestamp_chat.client.TimestampChatClient;
import cc.abbie.timestamp_chat.client.config.ConfigAutoConfigImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@EventBusSubscriber(value = Dist.CLIENT, modid = TimestampChat.MODID)
public class TimestampChatNeoForgeClient {
    @SubscribeEvent
    public static void onSetup(FMLClientSetupEvent e) {
        TimestampChatClient.init();

        if (Platform.isClothConfigLoaded()) {
            ModLoadingContext.get().registerExtensionPoint(
                    IConfigScreenFactory.class,
                    () -> (client, parent) -> ConfigAutoConfigImpl.openConfigScreen(parent)
            );
        }
    }

    @SubscribeEvent
    public static void onChatReceived(ClientChatReceivedEvent e) {
        e.setMessage(Timestamp.addToMessage(e.getMessage()));
    }
}

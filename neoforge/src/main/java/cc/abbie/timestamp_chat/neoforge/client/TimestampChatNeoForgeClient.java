package cc.abbie.timestamp_chat.neoforge.client;

import cc.abbie.timestamp_chat.Platform;
import cc.abbie.timestamp_chat.TimestampChat;
import cc.abbie.timestamp_chat.client.Timestamp;
import cc.abbie.timestamp_chat.client.TimestampChatClient;
import cc.abbie.timestamp_chat.client.config.ConfigAutoConfigImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.ConfigScreenHandler;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TimestampChat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TimestampChatNeoForgeClient {
    @SubscribeEvent
    public static void onSetup(FMLClientSetupEvent e) {
        TimestampChatClient.init();

        if (Platform.isClothConfigLoaded()) {
            ModLoadingContext.get().registerExtensionPoint(
                    ConfigScreenHandler.ConfigScreenFactory.class,
                    () -> new ConfigScreenHandler.ConfigScreenFactory(
                            (client, parent) -> ConfigAutoConfigImpl.openConfigScreen(parent)
                    )
            );
        }

        NeoForge.EVENT_BUS.addListener(TimestampChatNeoForgeClient::onChatReceived);
    }

    public static void onChatReceived(ClientChatReceivedEvent e) {
        e.setMessage(Timestamp.addToMessage(e.getMessage()));
    }
}

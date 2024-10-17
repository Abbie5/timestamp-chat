package cc.abbie.timestamp_chat.neoforge;

import cc.abbie.timestamp_chat.Platform;
import cc.abbie.timestamp_chat.Timestamp;
import cc.abbie.timestamp_chat.TimestampChatClient;
import cc.abbie.timestamp_chat.config.ConfigAutoConfigImpl;
import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.client.ConfigScreenHandler;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod("timestamp_chat")
@OnlyIn(Dist.CLIENT)
public class TimestampChatForge {
    public TimestampChatForge() {
        FMLJavaModLoadingContext.get()
                .getModEventBus()
                .addListener((FMLClientSetupEvent e) -> TimestampChatClient.init());

        if (Platform.isClothConfigLoaded()) {
            ModLoadingContext.get().registerExtensionPoint(
                    ConfigScreenHandler.ConfigScreenFactory.class,
                    () -> new ConfigScreenHandler.ConfigScreenFactory(
                            (client, parent) -> ConfigAutoConfigImpl.openConfigScreen(parent)
                    )
            );
        }

        NeoForge.EVENT_BUS.<ClientChatReceivedEvent>addListener(e ->
                e.setMessage(Timestamp.addToMessage(e.getMessage()))
        );
    }
}

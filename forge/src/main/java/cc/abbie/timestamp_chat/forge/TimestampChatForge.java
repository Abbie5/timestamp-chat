package cc.abbie.timestamp_chat.forge;

import cc.abbie.timestamp_chat.TimestampChatClient;
import cc.abbie.timestamp_chat.config.Config;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("timestamp_chat")
@OnlyIn(Dist.CLIENT)
public class TimestampChatForge {
    public TimestampChatForge() {
        FMLJavaModLoadingContext.get()
                .getModEventBus()
                .addListener((FMLClientSetupEvent e) -> TimestampChatClient.init());
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (client, parent) -> AutoConfig.getConfigScreen(Config.class, parent).get()
                )
        );
    }
}

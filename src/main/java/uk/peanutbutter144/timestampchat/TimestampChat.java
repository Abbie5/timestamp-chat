package uk.peanutbutter144.timestampchat;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.config.ModConfig;

@Mod(TimestampChat.MODID)
@OnlyIn(Dist.CLIENT)
public class TimestampChat {
    public static final String MODID = "timestamp-chat";

    public TimestampChat() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, TimestampChatConfig.clientSpec);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event) {
        if (event.getType() == ChatType.GAME_INFO) return;
        final String format = TimestampChatConfig.CLIENT.format.get();
        final String timestamp = new SimpleDateFormat(format)
                .format(new Date());
        final ITextComponent msg = ((ITextComponent) new StringTextComponent(""))
                .appendText(timestamp) // timestamp - format is embedded
                .appendText(" ") // separator (space)
                .appendSibling(event.getMessage());
        event.setMessage(msg);
    }
}

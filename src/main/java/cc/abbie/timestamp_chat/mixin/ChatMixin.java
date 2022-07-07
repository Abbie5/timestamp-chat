package cc.abbie.timestamp_chat.mixin;

import cc.abbie.timestamp_chat.config.Config;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.text.SimpleDateFormat;
import java.util.Date;


@Mixin(ChatHud.class)
public class ChatMixin {
    @ModifyVariable(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"), argsOnly = true)
    public Text onAddMessage(Text message) {
        Config config = AutoConfig.getConfigHolder(Config.class).getConfig();

        return Text.empty()
                .append(
                        Text.literal(new SimpleDateFormat(config.pattern).format(new Date()))
                                .setStyle(Style.EMPTY.withColor(config.color))
                )
                .append(" ")
                .append(message);
    }
}

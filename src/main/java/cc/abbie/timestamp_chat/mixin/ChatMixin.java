package cc.abbie.timestamp_chat.mixin;

import cc.abbie.timestamp_chat.Config;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
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

		return MutableText.of(TextContent.EMPTY)
				.append(new SimpleDateFormat(config.pattern).format(new Date()))
				.append(" ")
				.append(message);
	}
}

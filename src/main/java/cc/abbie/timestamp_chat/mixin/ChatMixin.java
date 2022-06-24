package cc.abbie.timestamp_chat.mixin;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.component.TextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.text.SimpleDateFormat;
import java.util.Date;

import static cc.abbie.timestamp_chat.TimestampChat.PATTERN;

@Mixin(ChatHud.class)
public class ChatMixin {
	@ModifyVariable(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"), argsOnly = true)
	public Text onAddMessage(Text message) {
		return MutableText.create(TextComponent.EMPTY)
				.append(new SimpleDateFormat(PATTERN).format(new Date()))
				.append(message);
	}
}

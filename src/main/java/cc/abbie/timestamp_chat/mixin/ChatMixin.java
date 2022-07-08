package cc.abbie.timestamp_chat.mixin;

import cc.abbie.timestamp_chat.Timestamp;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChatHud.class)
public class ChatMixin {
    @ModifyVariable(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"), argsOnly = true)
    private Text onAddMessage(Text message) {
        return Text.empty().append(Timestamp.create()).append(" ").append(message);
    }
}

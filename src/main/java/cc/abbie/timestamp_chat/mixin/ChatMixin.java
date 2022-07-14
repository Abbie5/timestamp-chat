package cc.abbie.timestamp_chat.mixin;

import cc.abbie.timestamp_chat.Timestamp;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChatComponent.class)
public class ChatMixin {
    @ModifyVariable(method = "addMessage(Lnet/minecraft/network/chat/Component;)V", at = @At("HEAD"), argsOnly = true)
    private Component onAddMessage(Component message) {
        return Component.empty().append(Timestamp.create()).append(" ").append(message);
    }
}

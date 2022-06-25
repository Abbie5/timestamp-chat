package cc.abbie.timestamp_chat.mixin;

import cc.abbie.timestamp_chat.Config;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Main.class)
public class InitMixin {
    @Inject(method = "main", at = @At("HEAD"))
    private static void registerConfig(CallbackInfo ci) {
        AutoConfig.register(Config.class, Toml4jConfigSerializer::new);
    }
}

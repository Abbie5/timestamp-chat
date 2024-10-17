package cc.abbie.timestamp_chat.neoforge;

import net.neoforged.fml.ModList;

public class PlatformImpl {
    public static boolean isClothConfigLoaded() {
        return ModList.get().isLoaded("cloth_config");
    }
}

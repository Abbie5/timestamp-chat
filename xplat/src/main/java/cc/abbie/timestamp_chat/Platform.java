package cc.abbie.timestamp_chat;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Platform {
    @ExpectPlatform
    public static boolean isClothConfigLoaded() {
        throw new AssertionError();
    }
}

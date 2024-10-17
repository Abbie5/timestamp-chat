package cc.abbie.timestamp_chat;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import java.text.SimpleDateFormat;
import java.util.Date;

import static cc.abbie.timestamp_chat.TimestampChatClient.CONFIG;

public class Timestamp {
    public static Component create() {
        return Component.literal(
                new SimpleDateFormat(CONFIG.pattern()).format(new Date())
        ).setStyle(Style.EMPTY.withColor(CONFIG.color()));
    }

    public static Component addToMessage(Component message) {
        return Component.empty().append(create()).append(" ").append(message);
    }
}

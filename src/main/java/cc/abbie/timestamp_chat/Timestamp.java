package cc.abbie.timestamp_chat;

import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import static cc.abbie.timestamp_chat.TimestampChatClient.CONFIG;

public class Timestamp {
    public static Text create() {
        return Text.literal(
                new SimpleDateFormat(CONFIG.pattern).format(new Date())
        ).setStyle(Style.EMPTY.withColor(CONFIG.color));
    }
}

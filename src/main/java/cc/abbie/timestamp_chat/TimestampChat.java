package cc.abbie.timestamp_chat;

import cc.abbie.timestamp_chat.config.TimestampChatConfig;
import org.quiltmc.config.api.Config;
import org.quiltmc.config.api.values.TrackedValue;
import org.quiltmc.loader.api.config.QuiltConfig;

import java.util.List;

public class TimestampChat {
	public static final Config CONFIG = QuiltConfig.create("timestamp-chat", "config", TimestampChatConfig.class);
	public static final String PATTERN = (String) CONFIG.getValue(List.of("pattern")).value();
}

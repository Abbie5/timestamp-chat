package cc.abbie.timestamp_chat.config;

import org.quiltmc.config.api.WrappedConfig;
import org.quiltmc.config.api.annotations.Comment;

public class TimestampChatConfig extends WrappedConfig {
	@Comment("Uses Java SimpleDateFormat syntax")
	public final String pattern = "HH:mm ";
}

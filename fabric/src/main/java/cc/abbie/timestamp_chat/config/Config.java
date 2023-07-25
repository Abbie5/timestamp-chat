package cc.abbie.timestamp_chat.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@me.shedaniel.autoconfig.annotation.Config(name = "timestamp_chat")
public class Config implements ConfigData {
	public String pattern = "HH:mm";

	@ConfigEntry.ColorPicker
	public int color = 0x888888;
}

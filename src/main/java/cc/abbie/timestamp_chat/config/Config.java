package cc.abbie.timestamp_chat.config;

import me.shedaniel.autoconfig.ConfigData;

@me.shedaniel.autoconfig.annotation.Config(name = "timestamp_chat")
public class Config implements ConfigData {
	public String pattern = "HH:mm";
}

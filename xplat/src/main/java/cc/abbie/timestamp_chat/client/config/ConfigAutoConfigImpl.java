package cc.abbie.timestamp_chat.client.config;

import cc.abbie.timestamp_chat.TimestampChat;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.client.gui.screens.Screen;

import static cc.abbie.timestamp_chat.client.config.DefaultConfigImpl.DEFAULT;

@me.shedaniel.autoconfig.annotation.Config(name = TimestampChat.MODID)
public class ConfigAutoConfigImpl implements ConfigData, Config {
	public String pattern = DEFAULT.pattern();

	@ConfigEntry.ColorPicker
	public int color = DEFAULT.color();


	@Override
	public String pattern() {
		return pattern;
	}

	@Override
	public int color() {
		return color;
	}

	public static Config register() {
		AutoConfig.register(ConfigAutoConfigImpl.class, Toml4jConfigSerializer::new);
		return AutoConfig.getConfigHolder(ConfigAutoConfigImpl.class).getConfig();
	}

	public static Screen openConfigScreen(Screen parent) {
		return AutoConfig.getConfigScreen(ConfigAutoConfigImpl.class, parent).get();
	}
}

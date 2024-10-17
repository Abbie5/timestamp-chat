package cc.abbie.timestamp_chat.fabric.client.compat.modmenu;

import cc.abbie.timestamp_chat.client.config.ConfigAutoConfigImpl;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class ModMenuPlugin implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(ConfigAutoConfigImpl.class, parent).get();
    }
}

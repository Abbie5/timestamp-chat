package cc.abbie.timestamp_chat.fabric.client.compat.modmenu;

import cc.abbie.timestamp_chat.client.config.ConfigAutoConfigImpl;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuPlugin implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigAutoConfigImpl::openConfigScreen;
    }
}

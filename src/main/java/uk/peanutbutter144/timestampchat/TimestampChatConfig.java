package uk.peanutbutter144.timestampchat;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TimestampChatConfig {
    public static class Client {
        public final ForgeConfigSpec.ConfigValue<String> format;

        Client(ForgeConfigSpec.Builder builder) {
            builder.push("client");
            format =
                    builder
                            .comment(
                                    "Format for timestamp. Uses SimpleDateFormat for date formatting and Minecraft format codes using \u00a7 for colours.")
                            .define("format", "'\u00a77\u00a7o'[HH:mm]'\u00a7r'");
            builder.pop();
        }
    }

    static final ForgeConfigSpec clientSpec;
    public static final Client CLIENT;

    static {
        final Pair<Client, ForgeConfigSpec> specPair =
                new ForgeConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }
}

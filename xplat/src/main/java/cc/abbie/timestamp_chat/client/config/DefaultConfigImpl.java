package cc.abbie.timestamp_chat.client.config;

public class DefaultConfigImpl implements Config {

    public static Config DEFAULT = new DefaultConfigImpl();

    private DefaultConfigImpl() {}

    @Override
    public String pattern() {
        return "HH:mm";
    }

    @Override
    public int color() {
        return 0x888888;
    }
}

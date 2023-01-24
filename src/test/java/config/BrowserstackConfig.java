package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${environment}.properties")
public interface BrowserstackConfig extends Config{
    String user();
    String key();
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String app();
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String url();
}

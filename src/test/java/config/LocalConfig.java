package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${environment}.properties")
public interface LocalConfig extends Config{
    String platformName();
    String deviceName();
    String platformVersion();
    String appiumServerUrl();
    String appPackage();
    String appActivity();
}

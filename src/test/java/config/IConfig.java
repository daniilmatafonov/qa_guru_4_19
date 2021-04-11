package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface IConfig extends Config {

    @Key("timeout")
    int timeout();

    @Key("startMaximized")
    boolean startMaximized();

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("browserstack.app.url")
    String browserstackAppUrl();

}

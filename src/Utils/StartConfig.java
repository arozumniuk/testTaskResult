package Utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Mutable;

@Config.Sources({"file:src/Utils/StartConfig.properties"})
public interface StartConfig extends Mutable {

    @Key("user.email")
    String login();

    @Key("user.password")
    String password();

    @Key("environmentName")
    @DefaultValue("prod")
    String environmentName();

    @Key("suiteFile")
    String suiteFile();

    @Key("browser")
    String browser();

    int logLevel();

    int defaultWait();

    int defaultImplicitlyWait();

    int defaultWaitForReceiveResponse();

    @Key("${environmentName}.startUrl")
    String startUrl();

}

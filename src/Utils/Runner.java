package Utils;

import org.aeonbits.owner.ConfigFactory;

import java.util.Objects;

public class Runner {

    private static StartConfig cfg;

    public static StartConfig getCfg() {
        if (cfg == null) {
            cfg = ConfigFactory.create(StartConfig.class);
            if (!Objects.equals(System.getProperty("environmentName"), null)) {
                cfg.setProperty("environmentName", System.getProperty("environmentName"));
            }
            if (!Objects.equals(System.getProperty("logLevel"), null)) {
                cfg.setProperty("logLevel", System.getProperty("logLevel"));
            }
            if (!Objects.equals(System.getProperty("userLogin"), null)) {
                cfg.setProperty("user.email", System.getProperty("userLogin"));
            }
            if (!Objects.equals(System.getProperty("userPassword"), null)) {
                cfg.setProperty("user.password", System.getProperty("userPassword"));
            }
            if (!Objects.equals(System.getProperty("suiteFile"), null)) {
                cfg.setProperty("suiteFile", System.getProperty("suiteFile"));
            }
            if (!Objects.equals(System.getProperty("browser"), null)) {
                cfg.setProperty("browser", System.getProperty("browser"));
            }
            if (!Objects.equals(System.getProperty("defaultWait"), null)) {
                cfg.setProperty("defaultWait", System.getProperty("defaultWait"));
            }
            if (!Objects.equals(System.getProperty("defaultImplicitlyWait"), null)) {
                cfg.setProperty("defaultImplicitlyWait", System.getProperty("defaultImplicitlyWait"));
            }
            if (!Objects.equals(System.getProperty("defaultWaitForReceiveResponse"), null)) {
                cfg.setProperty("defaultWaitForReceiveResponse", System.getProperty("defaultWaitForReceiveResponse"));
            }
        }
        return cfg;
    }
}

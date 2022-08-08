package com.classroomservices.ClassRoomSvcs.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="app-config")
public class AppConfig {
    private Map<String, String> appOne;
    private Map<String, String> appTwo;

    public Map<String, String> getAppOne() {
        return appOne;
    }
    public void setAppOne(Map<String, String> appOne) {
        this.appOne = appOne;
    }

    public Map<String, String> getAppTwo() {
        return appTwo;
    }

    public void setAppTwo(Map<String, String> appTwo) {
        this.appTwo = appTwo;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appOne=" + appOne +
                ", appTwo=" + appTwo +
                '}';
    }
}

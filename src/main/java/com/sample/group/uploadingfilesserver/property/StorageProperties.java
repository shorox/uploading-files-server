package com.sample.group.uploadingfilesserver.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("property")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

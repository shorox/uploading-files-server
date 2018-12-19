package com.sample.group.uploadingfilesserver;

import com.sample.group.uploadingfilesserver.service.StorageService;
import com.sample.group.uploadingfilesserver.property.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadingFilesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingFilesServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}


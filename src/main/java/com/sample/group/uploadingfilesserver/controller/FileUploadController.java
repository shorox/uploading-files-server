package com.sample.group.uploadingfilesserver.controller;

import com.sample.group.uploadingfilesserver.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {

    @Autowired
    private StorageService storageService;

    @GetMapping
    public List<String> allFiles(){
        return storageService
                .loadAll()
                .map(o -> o.getFileName().toString())
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {

        storageService.store(file);
    }

}

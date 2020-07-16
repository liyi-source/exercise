package com.ly.upload.managentupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ManagentUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagentUploadApplication.class, args);
    }

}

package com.ly.upload.managentupload.controller;


import com.ly.upload.managentupload.ManagentUploadApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=ManagentUploadApplication.class)
@RunWith(SpringRunner.class)
public class RabbitControllerTest {

    @Test
    public void test(){
        System.out.println("进来");
    }
}

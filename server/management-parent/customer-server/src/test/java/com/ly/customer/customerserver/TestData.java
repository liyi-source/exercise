package com.ly.customer.customerserver;

import com.ly.customer.customerserver.utils.AESUtils;
import com.ly.customer.customerserver.utils.AccessTokenUtils;
import com.ly.customer.customerserver.utils.AppUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=CustomerServerApplication.class)
@RunWith(SpringRunner.class)
public class TestData {


    @Test
    public void testGetToken(){
        try {
//            String appId=AppUtils.getAppId();
//            String appSecript=AppUtils.uuid(14);
//            System.out.println(appId+"=="+appSecript);
            //获取token
            String token=AccessTokenUtils.getToken("Sfmklob5KIFVcCAF","X2bSFzErhdxEPj5lfIGtk4");
            System.out.println(token);
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    @Test
    public void testCheckToken(){
        boolean bool=AccessTokenUtils.checkToken("d425aE24B393B4A81E9100CB6D10FEB5CB6CDDA6F85AD30C305F14158B46EA9BB3D8C84F206045BCD0EA953084CC64AF16E95429A34FD1A5C6A22146ABC149216D3747D869D3165617A4D3CC61AC975F021223BB4D2C739BF5EBCDCE8A921A718BDEA");
        System.out.println(bool);

    }
}

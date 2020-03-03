package cn.mo.myclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MyClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(MyClient1Application.class, args);
    }

}

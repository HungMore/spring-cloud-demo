package cn.mo.springbootdemo.java_se.net;

import java.net.InetAddress;

/**
 * desc:
 *
 * @author mozhihang
 * date:2020/3/4 9:14
 */
public class NetTest {

    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getByName("https://www.baidu.com");
        System.out.println(inetAddress.getHostAddress()+"--");
    }

}


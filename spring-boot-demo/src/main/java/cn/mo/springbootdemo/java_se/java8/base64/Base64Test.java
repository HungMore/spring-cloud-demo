package cn.mo.springbootdemo.java_se.java8.base64;

import java.util.Base64;

/**
 * desc: java8 base64 编解码的简单使用
 * @author mozhihang
 * date:2020/3/10 16:54
 */
public class Base64Test {

    public static void main(String[] args) throws Exception {
        // 编码
        Base64.Encoder encoder = Base64.getEncoder();
        String email = "1254274155@qq.com";
        String encodedEmail = encoder.encodeToString(email.getBytes("UTF-8"));
        System.out.println("encodedEmail: "+encodedEmail);

        // 解码
        Base64.Decoder decoder = Base64.getDecoder();
        String decodedEmail = new String(decoder.decode(encodedEmail), "UTF-8");
        System.out.println("decodedEmail: "+decodedEmail);

    }

}

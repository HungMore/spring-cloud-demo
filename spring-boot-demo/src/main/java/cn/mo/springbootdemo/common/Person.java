package cn.mo.springbootdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * desc: 测试需要用到的示例类
 * @author mozhihang
 * date:2020/3/10 17:20
 */
@Data
@AllArgsConstructor
public class Person extends Animal {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 是否是雄性
     */
    private Boolean isMale;

    /**
     * 邮箱
     */
    private String email;

    // TODO
    private static final String regex = "(?<=@)\\w+(?=.com)";

    public String getEmailType(){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);
        if(matcher.find()){
            return matcher.group(0);
        }else{
            return "";
        }
    }


}

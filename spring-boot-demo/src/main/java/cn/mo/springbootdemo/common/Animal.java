package cn.mo.springbootdemo.common;

import lombok.Data;

/**
 * desc: 测试需要用到的示例类
 * @author mozhihang
 * date:2020/3/10 17:21
 */
@Data
public class Animal {

    /**
     * 居住的星球，默认是地球
     */
    private String livingPlanet = "地球";

}

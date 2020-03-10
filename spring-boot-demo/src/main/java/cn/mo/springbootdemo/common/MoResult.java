package cn.mo.springbootdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * desc: 前后端分离返回数据的模板类，要实现序列化接口，保证传输
 * @author mozhihang
 * date:2020/3/10 17:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public MoResult(Integer code, String msg){
       this.code = code;
       this.msg = msg;
       this.data = null;
    }

    public static MoResult succeed(){
        return new MoResult(200, "ok");
    }

    public static MoResult fail(){
        return new MoResult(400, "系统错误");
    }

    public MoResult(T data){
        this.code = 200;
        this.msg = "ok";
        this.data = data;
    }

}

package cn.mo.springbootdemo.java_se;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * desc:
 *
 * @author mozhihang
 * date:2020/3/5 17:09
 */
public class MyTest {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName("123");
        Person person = new Person();
        person.setGender("男");
        BeanUtils.copyProperties(animal, person);
        System.out.println(person.getName());
    }

}

@Data
class Animal{

    private String name;

}

@Data
class Person extends Animal{

    private String gender;

}

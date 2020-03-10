package cn.mo.springbootdemo.java_se.java8.stream;

import cn.mo.springbootdemo.common.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * desc: java8 stream 的简单使用
 *
 * @author mozhihang
 * date:2020/3/10 17:02
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("小一", 1, true, "xiaoyi@qq.com"),
                new Person("小二", 2, false, "xiaoer@163.com"),
                new Person("小三", 3, true, "xiaosan@163.com"),
                new Person("小四", 4, false, "xiaosi@qq.com"),
                new Person("小五", 5, true, "xiaowu@163.com")
        );

        // filter 条件过滤，skip 跳过若干条目，limit 限定条目
        // skip(n) + limit(n) 可以起到分页的效果
        List<Person> ageGt3 = personList.stream().filter(person -> person.getAge() > 3).skip(1).limit(1).collect(Collectors.toList());
        ageGt3.forEach(person -> System.out.println(person + " 居住的星球：" + person.getLivingPlanet()));

        // 根据QQ邮箱和163邮箱进行聚合
        Map<String, List<Person>> emailTypeMap = personList.stream().collect(Collectors.groupingBy(Person::getEmailType));
        for (Map.Entry<String, List<Person>> entry : emailTypeMap.entrySet()) {
            System.out.print(entry.getKey() + "：");
            entry.getValue().stream().forEach(person -> System.out.print(person.getName()+" "));
            System.out.println();
        }

        // todo 记到快捷键文档中 ctrl + f12 查看类有哪些方法
    }

}

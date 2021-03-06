### NOTE 

> 记录编码过程中遇到的一些问题！

#### 2020.03.05

- Apollo刷新的确可以实时同步到服务中，但是@ConfigurationProperties(prefix="")标注的配置类却并没有同步跟着刷新，添加以下代码即可保证配置类同步刷新：（除了以下全局刷新的方式外，还可以为配置类加上@RefreshScope注解保证该配置类同步实时刷新）
```java
@Component
public class ApplicationConfigChangeListener {

    @Resource
    private ContextRefresher contextRefresher;


    @ApolloConfigChangeListener(value = {"application.yml"})
    private void onChange(ConfigChangeEvent changeEvent) {
        contextRefresher.refresh();
    }
}
```

- 微服务架构中，一般都是只把网关服务暴露到外网，其他服务不暴露到外网（避免其他服务被绕过网关直接访问）。在网关进行了身份认证、鉴权工作以后，直接由网关走内网微服务调用其他的服务，保证了其他服务接口的安全。当然为了双重保障，各个微服务也可以再加个过滤器，过滤掉不来自网关的请求（如何判断请求是否来自网关？可以在网关处对请求的头部进行修改，加上“来自网关”的标识，服务通过该标识判断即可）

- ThreadLocal<T>是如何保证在微服务架构中的正常运行的？其实每个服务的ThreadLocal<T>实例肯定不是同一个，只是服务A调用服务B的时候，服务A通过把自己的线程变量放到请求头部中，服务B的拦截器拦截请求后，根据头部信息也构造一个属于自己的线程变量，这个线程变量和服务A的一模一样，效果上就犹如是线程变量的直接传递（但实际上，它们只是值完全一样，线程、ThreadLocal<T>实例都完全不同）。

- ThreadLocal<T>在集群下的使用？理解错了ThreadLocal<T>的用法啦！ThreadLocal<T>线程变量只在当前线程中有效，一个请求到达一个服务器之后就会创建一个线程，请求处理完成，线程也就终止了，对应的线程变量也没了呗。拦截器拦截每一个请求，为每一个请求创建一个线程变量，当这一个请求结束，线程终止，线程变量消失。

- 拦截器和过滤器在spring boot中的区别：[spring boot过滤器、拦截器的区别与使用](https://blog.csdn.net/heweimingming/article/details/79993591)


#### 2020.03.06

- xxl-job执行器没有指定调度中心的地址，调度中心直接指定执行器的地址、端口和appName，然后调度中心还是可以成功调度该执行器的任务的。这样是不是有很大的安全漏洞，我只要知道执行器的ip、端口和appName；就可以调度该执行器，或许执行器的xxl.job.accessToken还是很有必要设定一下的吧！但是这个xxl.job.accessToken有什么用呢，怎么把调度中心和执行器绑定起来？

#### 2020.03.06

- 今天“客服系统”有个账号登录不上CRM，首先查看了之前“客服负责人”给我的帐号映射表，发现给的CRM账号与实际不符，经过测试，的确就是CRM账号配错导致的登录失败，重新配置账号映射即解决了问题。由此明白了bug排查的步骤：先从最顶层进行排查，是否是使用、配置上的问题，如果不是，再查看日志分析代码。这个排查步骤和之前看计算机网络教程给的故障排查步骤是类似的，一层一层的排查（当然了，网络排查一般是从最底层开始的，首先判断网卡等是否连接正常）。

#### 2020.03.10

- 目前还没有发现问题！

#### 2020.03.16
- centOS配置环境变量出错的时候，可能会导致常用命令都不可用的，解决办法是：[环境变量配置出错弥补方法](https://www.iteye.com/blog/wuneng94zui-2262054)
- 




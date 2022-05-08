package com.itheima.a08.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
    如果 jdk > 8, 运行时请添加 --add-opens java.base/java.lang=ALL-UNNAMED
    @scope失效场景
    单例对象使用多例对象:单例对象仅注入一次多例对象
    方法一: 注入时使用@Lazy注解
    方法二: 定义时@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    方法三: 注入时ObjectFactory<F3> f3; get方法从工厂取, 不从代理取
    方法四: 注入ApplicationContext context;从容器取

 */
@ComponentScan("com.itheima.a08.sub")
public class A08_1 {

    private static final Logger log = LoggerFactory.getLogger(A08_1.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(A08_1.class);

        E e = context.getBean(E.class);
        log.debug("{}", e.getF1().getClass());
        log.debug("{}", e.getF1());
        log.debug("{}", e.getF1());
        log.debug("{}", e.getF1());

        log.debug("{}", e.getF2().getClass());
        log.debug("{}", e.getF2());
        log.debug("{}", e.getF2());
        log.debug("{}", e.getF2());

        log.debug("{}", e.getF3());
        log.debug("{}", e.getF3());

        log.debug("{}", e.getF4());
        log.debug("{}", e.getF4());

        context.close();
        /*
            学到了什么
                a. 单例注入其它 scope 的四种解决方法
                b. 解决方法虽然不同, 但理念上殊途同归: 都是推迟其它 scope bean 的获取
         */
    }
}

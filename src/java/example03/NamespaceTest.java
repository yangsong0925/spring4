package example03;

import base.bean.CDPlayer;
import base.bean.CompactDisc;
import example03.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * SpringJUnit4ClassRunner 测试自动创建Spring应用上下文
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * @ContextConfiguration 加载指定配置文件
 *     String[] value() default {};
 *     String[] locations() default {};             XmlConfig  path
 *     Class<?>[] classes() default {};             JavaConfig path
 *     Class<? extends ApplicationContextInitializer<? extends ConfigurableApplicationContext>>[] initializers() default {};
 *     boolean inheritLocations() default true;
 *     boolean inheritInitializers() default true;
 *     Class<? extends ContextLoader> loader() default ContextLoader.class;
 *     String name() default "";
 *
 *  tip: locations classes 不能同时使用。每个@ContextConfiguration注释只允许一个资源声明。
 *
 *     @ContextConfiguration(classes = {example01.config.JavaConfig.class})
 */
@ContextConfiguration(locations = {"classpath:example03/resource/XmlConfig.xml"})
public class NamespaceTest {

    @Resource
    private User user;

    @Test
    public void name() {
        System.out.println(user);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:example03/resource/XmlConfig.xml");
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);
    }

}

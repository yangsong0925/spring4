package example01.config;


import example01.bean.CompactDisc;
import example01.bean.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ComponentScan 默认以配置类所在的基础包(base package)包括子包 等同于 <context:component-scan base-package=""/>
 *  value 设置包名称
 *  basePackages 复数形式，设置多个基础包 eg: basePackages={"package1 ","package2"}
 *  basePackageClasses 设置多个组件类，类所在的包作为基础包 eg: basePackageClasses={ClassPackage1.class,ClassPackage2.class}
 *      Tip: basePackages 设置包名是以String类型表示的，是类型不安全的，重构代码基础包可能有误。可以使用basePackageClasses代替。
 *
 */
@ComponentScan
/**
 * @Configuration 表明该类为 配置类，包含Spring应用上下文如何创建 bean 的细节。
 */
@Configuration
public class JavaConfig {

    /**
     * @Bean 标注该方法返回一个对象，将该对象注册为Spring应用上下文中的bean。方法体中包含了最终产生bean实例的逻辑。
     */
    @Bean
    public CompactDisc sgtPeppers(){
        return  new SgtPeppers();
    }

}

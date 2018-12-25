#### 裝配 Bean
Spring 实现自动化装配角度：
    1. 组件扫描（Component scanning）：Spring 会自动发现应用上下文中所创建的 Bean。
    2. 自动装配（autowiring）：Spring 自动满足 bean 之间的依赖。

JavaConfig 引入配置文件：
    1. JavaConfig： @Import() 传入 JavaConfig Class 数组。
       public @interface Import {
           Class<?>[] value();
       }
       
       
    2. XmlConfig： @ImportResource() XmlConfig path 数组。
        public @interface ImportResource {
            String[] value();
            Class<? extends BeanDefinitionReader> reader() default XmlBeanDefinitionReader.class;
        }
        
        eg: @ImportResource("classpath:example01/resource/XmlConfig.xml")
        
XmlConfig 引入配置文件：
    1. JavaConfig：<bean/> 注册java bean。
       
    2. XmlConfig：<import resource="" />  classpath*: classpath: file: http:






测试：
    SpringJUnit4ClassRunner 测试自动创建Spring应用上下文
    @RunWith(SpringJUnit4ClassRunner.class)
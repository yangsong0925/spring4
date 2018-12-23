#### 裝配 Bean
Spring 实现自动化装配角度：
    1. 组件扫描（Component scanning）：Spring 会自动发现应用上下文中所创建的 Bean。
    2. 自动装配（autowiring）：Spring 自动满足 bean 之间的依赖。
    
```$java
    @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次。 默认: 可设置bean的名字
    
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        @Documented
        public @interface Component {
            String value() default "";
        }
        
        


```






测试：
    SpringJUnit4ClassRunner 测试自动创建Spring应用上下文
    @RunWith(SpringJUnit4ClassRunner.class)
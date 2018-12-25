
```$java
@Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次。 默认: 可设置bean的名字。
    Java 依赖注入规范（Java Dependency Injection） @Named 相同效果。
     
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Component {
        String value() default "";
    }
       
       
@Autowired 按照【类型】注入。 （Spring 特有注解）
    Java 依赖注入规范（Java Dependency Injection） @Inject 相同效果。
    
    boolean required() default true;
    true: 应用上下文创建时，无匹配 Bean ，Spring 会抛出一个异常 NoSuchBeanDefinitionException 。 false: 属性值可能为 Null。

@Autowired + @Qualifier("名称") 按照【名称】注入。(存在多个可注入Bean时，通过 @Qualifier 指定)。 
@Resource("名称") 按照【名称】注入。( 作用是上面的合集)




```



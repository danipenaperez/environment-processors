# environment-processors
Simple SpringBoot preprocessors executions for loading properties and injecting beans

# Introducction

This project has a preprocessor (BeanDefinitionRegistryPostProcessor, BeanPostProcessor). 
At this point reads manually a configuration yaml file, and inject manually Beans on context.

Use manually [Binder](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/bind/Binder.html) operations to marshall yaml properties to Java Objecs.

Show how to parse, simple object, Map of objects and a List of objects.

After that RaceCarService can be instantiated because the TestingConfigurationProperties is already available at context.

# Execution

As usual 

```sh
mvn clean install spring-boot:run
```

# StackOverflow

This is a example to answer this question at stackoverflow [https://stackoverflow.com/questions/77495551/how-spring-boot-binder-can-resolve-nested-objects](https://stackoverflow.com/questions/77495551/how-spring-boot-binder-can-resolve-nested-objects)
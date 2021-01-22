# spring-boot-kpi 
---
[![Build Status](https://travis-ci.org/rakjido/spring-boot-kpi.svg?branch=master)](https://travis-ci.org/rakjido/spring-boot-kpi)



### Overview

This simple application was inspired by __'How to Prioritize Your Time'__ in Y Combinator's youtube channel

[https://www.youtube.com/watch?v=XcCmMOWuAF4](https://www.youtube.com/watch?v=XcCmMOWuAF4)





```
* Project : Gradle Project
* Language : Java 1.8
* Spring boot : 2.1.7.RELEASE
* Depencencies : Web, Lombok, Devtools, JPA, H2, Mysql, Mustache, AOP
```


![main](/doc/spring-boot-kpi.png)

### Usage

Create tables in your Mysql using [this script](https://github.com/rakjido/spring-boot-kpi/blob/master/doc/table.ddl)



```bash
./gradlew clean build
```

```bash
cd build/libs/
```

Create your ```application.properties``` file as the following listing shows

```
spring.datasource.url=jdbc:mysql://DatabaseIP:Port/DatabaseName?useSSL=false&useUnicode=true&serverTimezone=UTC

spring.datasource.username=id
spring.datasource.password=password
```



Run the applcation

```bash
nohup java -jar -Dspring.config.location=application.properties agile-0.0.1-SNAPSHOT.jar &
```




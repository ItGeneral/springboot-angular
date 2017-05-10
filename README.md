# webProject

## 框架：  
SpringBoot  
MYSQL  
RabbitMQ   
Mybatis  

## RabbitMQ:  
1、安装请参考: https://mp.weixin.qq.com/s/esWbvloVmQuAoXhmFFGbOg   
2、访问RabbitMQ管理页面: http://localhost:15672；用户名和密码：guest/guest  
3、调用ProducerService类的sender()方法,发送消息至消息队列  
4、在ConsumerListener类的onMessage()方法中消费消息队列中的消息，可在其中根据消费数据实现自己的业务逻辑  


## 登录模块原理  
1、用户登录后，将userId结合秘钥进行加密生成一个签名 返回给前端  
2、当用户再次访问后，再将userId结合秘钥生成一个签名，将新生成的签名和传过来的签名进行对比  
3、如果一样，则说明登陆了，如果不相同，则表示没有登录  

## profile设置环境配置  
1、在pom文件中设置`<profiles/>`，并且在<build/>中设置资源加载配置`<resources/> `   
2、在application.properties中添加配置`spring.profiles.active=@profiles.active@`  
3、在/src/main/resources/config目录下添加各个环境的配置文件application-${spring.profiles.active}.properties  
4、在DataSourcesConfig.java中设置需要加载的配置文件:`@PropertySource(value = {"classpath:/config/${spring.profiles.active}/application-${spring.profiles.active}.properties", "classpath:druid-monitor.properties"})`  
  详情请参见代码  

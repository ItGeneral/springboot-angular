# webProject

## 框架：  
SpringBoot  
MYSQL  
RabbitMQ   
Mybatis  

## RabbitMQ:  
安装请参考: https://mp.weixin.qq.com/s/esWbvloVmQuAoXhmFFGbOg   
访问RabbitMQ管理页面: http://localhost:15672 用户名和密码：guest/guest  
调用ProducerService类的sender()方法,发送消息至消息队列  
在ConsumerListener类的onMessage()方法中消费消息队列中的消息，可在其中根据消费数据实现自己的业务逻辑  


## 登录模块原理  
用户登录后，将userId结合秘钥进行加密生成一个签名 返回给前端  
当用户再次访问后，再将userId结合秘钥生成一个签名，将新生成的签名和传过来的签名进行对比  
如果一样，则说明登陆了，如果不相同，则表示没有登录
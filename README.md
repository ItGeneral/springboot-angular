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

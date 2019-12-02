## kafka
1. 启动 `zookeeper`
    ```$xslt
    cd /Users/liuyanzhao/Documents/JavaStudy/zookeeper-3.4.13
    sh bin/zkServer.sh start
    ```

2. 启动 `kafka`
    ```$xslt
    cd /Users/liuyanzhao/Documents/JavaStudy/kafka_2.12-2.3.1
    bin/kafka-server-start.sh config/server.properties
    ```

## RocketMQ
1. 启动 `nameserver`
    ```$xslt
    cd /Users/liuyanzhao/Documents/JavaStudy/rocketmq-all-4.4.0
    nohup sh bin/mqnamesrv &
    ```

2. 启动 `broker`
    ```$xslt
    nohup sh bin/mqbroker -n localhost:9876 &
    ```
    
    
## RabbitMQ
1. 安装
使用 `Homebrew` 安装
```$xslt
brew install rabbitmq
export PATH=$PATH:/usr/local/opt/rabbitmq/sbin
```
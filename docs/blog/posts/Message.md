---
date: 
    created: 2024-01-01

---

# Message


### kafka

Topic 分成 Partion, 分区仅 1 Consumer 消费，记录 消费 offset. 


#### 高可用

- 不同的Broker分散运行在不同的机器上
- Replication
  - 领导者副本（Leader Replica） : 生产者总是向领导者副本写消息；而消费者总是从领导者副本读消息
  - 追随者副本（Follower Replica : 请求领导者把最新生产的消息发给它，这样它能保持与领导者的同步。
- Partitioning
  - 分区机制指的是将每个主题划分成多个分区（Partition），每个分区是一组有序的消息日志

```
Kafka的三层消息架构：

第一层是主题层，每个主题可以配置M个分区，而每个分区又可以配置N个副本。
第二层是分区层，每个分区的N个副本中只能有一个充当领导者角色，对外提供服务；其他N-1个副本是追随者副本，只是提供数据冗余之用。
第三层是消息层，分区中包含若干条消息，每条消息的位移从0开始，依次递增。
最后，客户端程序只能与分区的领导者副本进行交互

```




#### [rebalance 问题](https://learn.lianglianglee.com/%e4%b8%93%e6%a0%8f/Kafka%e6%a0%b8%e5%bf%83%e6%8a%80%e6%9c%af%e4%b8%8e%e5%ae%9e%e6%88%98/17%20%e6%b6%88%e8%b4%b9%e8%80%85%e7%bb%84%e9%87%8d%e5%b9%b3%e8%a1%a1%e8%83%bd%e9%81%bf%e5%85%8d%e5%90%97%ef%bc%9f.md)

Rebalance就是让一个Consumer Group下所有的Consumer实例就如何消费订阅主题的所有分区达成共识的过程。在Rebalance过程中，所有Consumer实例共同参与，在协调者组件的帮助下，完成订阅主题分区的分配。但是，在整个过程中，所有实例都不能消费任何消息，因此它对Consumer的TPS影响很大。

- 组成员数量变化
- 订阅主题数量变化
- 订阅主题分区变化

解决方案

后期版本提供 StickyAssignor feature，粘性的分区分配策略，保留之前的分配方案，实现分区分配的最小变动

Consumer 
    session.timeout.ms
    heartbeat.interval.ms

#### 消费者组

消费者组是Kafka提供的可扩展且具有容错性的消费者机制。

作为队列，消费者组允许你分割数据处理到一组进程集合上（即一个消费者组中可以包含多个消费者进程，他们共同消费该topic的数据），这有助于你的消费能力的动态调整；作为-订阅模型（publish-subscribe），Kafka允许你将同一份消息广播到多个消费者组里，以此来丰富多种数据使用场景

在消费者组中，多个实例共同订阅若干个主题，实现共同消费。同一个组下的每个实例都配置有相同的组ID，被分配不同的订阅分区。当某个实例挂掉的时候，其他实例会自动地承担起它负责消费的分区。因此，消费者组在一定程度上也保证了消费者程序的高可用性

#### Offset

[位移提交机制](https://learn.lianglianglee.com/%E4%B8%93%E6%A0%8F/Kafka%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF%E4%B8%8E%E5%AE%9E%E6%88%98/18%20Kafka%E4%B8%AD%E4%BD%8D%E7%A7%BB%E6%8F%90%E4%BA%A4%E9%82%A3%E4%BA%9B%E4%BA%8B%E5%84%BF.md)

Consumer的消费位移，它记录了Consumer要消费的下一条消息的位移。

```
假设一个分区中有10条消息，位移分别是0到9。某个Consumer应用已消费了5条消息，这就说明该Consumer消费了位移为0到4的5条消息，此时Consumer的位移是5，指向了下一条消息的位移。
```

#### why fast

Zero Copy
顺序写入
消息压缩
分批发送
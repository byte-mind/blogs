
---
date: 
    created: 2024-01-01

---

# 分布式锁

高并发场景下， 会发生数据竞争，可能会导致出现脏数据或者系统问题，威胁到程序的正常运行。

如 超卖问题

需要解决共享资源的互斥访问.

### [Redis](Cache.md#redis)

##### Redlock 
```
算法的思想是让客户端向 Redis 集群中的多个独立的 Redis 实例依次请求申请加锁，如果客户端能够和半数以上的实例成功地完成加锁操作，那么我们就认为，客户端成功地获得分布式锁，否则加锁失败。即使部分 Redis 节点出现问题，只要保证 Redis 集群中有半数以上的 Redis 节点可用，分布式锁服务就是正常的。Redlock 是直接操作 Redis 节点的，并不是通过 Redis 集群操作的，这样才可以避免 Redis 集群主从切换导致的锁丢失问题。

实现比较复杂，性能比较差，发生时钟变迁的情况下还存在安全性隐患.
[redlock-discussion](https://martin.kleppmann.com/2016/02/08/how-to-do-distributed-locking.html)
```


##### Redisson

在 Redis 的基础上实现的 Java 驻内存数据网格客户端（In-Memory Data Grid）
提供了一系列的 redis 常用数据结构命令服务,分布式锁、分布式对象、分布式集合、分布式远程服务、分布式调度任务服务等

###### RLock



### Java

ReetrantLock

synchronized


### Lock Type

Rentrant Lock

Spin Lock

Fair Lock

MultiLock

RedLock

ReadWriteLock
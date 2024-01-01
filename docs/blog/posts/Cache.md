---
date: 
    created: 2023-12-31
---

# Cache

### Redis

!!! info "why so fast"

![](20240101104811.png)

!!! info "supported applications"

[分布式锁](Cache.md#redis)

[限流](ratelimit.md#redis)

消息队列

延时队列

分布式session

##### 持久化

snapshotting, RDB

append-only, AOF

RDB & AOF


##### 集群

- Master Slave

- Sentinel

主从复制基础上加入了哨兵节点，实现了自动故障转移,会监控主节点和从节点的运行状态。当主节点发生故障时，哨兵节点会自动从从节点中选举出一个新的主节点，并通知其他从节点和客户端，实现故障转移。

- Cluster

Cluster模式下，Redis将所有的键值对数据分散在多个节点上。每个节点负责一部分数据，称为槽位。通过对数据的分片，Cluster模式可以突破单节点的内存限制，实现更大规模的数据存储。Redis Cluster将数据分为16384个槽位，每个节点负责管理一部分槽位。当客户端向Redis Cluster发送请求时，Cluster会根据键的哈希值将请求路由到相应的节点。具体来说，Redis Cluster使用CRC16算法计算键的哈希值，然后对16384取模，得到槽位编号
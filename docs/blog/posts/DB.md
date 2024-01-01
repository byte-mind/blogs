---
date: 
    created: 2023-12-30
tags:
    - DB
    - MySQL
---

# DB 

### MySQL

!!! info "Lock"

    | Category    | Desc                                                  |
    | ----------- | ----------------------------------------------------- |
    | table-level | Low Cost; Most Effectivive;  Highest lock conflicting |
    | row-level   | high cost; very slow; Lowest lock conflicting         |
    | page-level  |                                                       |


!!! info "索引"

[B+ tree](BTree.md) 

聚簇索引（聚集索引）：索引结构和数据一起存放的索引，InnoDB 中的主键索引就属于聚簇索引。
非聚簇索引（非聚集索引）：索引结构和数据分开存放的索引，二级索引(辅助索引)就属于非聚簇索引。
MySQL 的 MyISAM 引擎，不管主键还是非主键，使用的都是非聚簇索引。

!!! info "回滚的原理"

回滚原理是基于**undo log**实现的。 当一个事务开始时，MySQL会创建一个新的undo日志记录。 当事务中的每一个操作被执行时，都会在**undo log**中添加一条相反的操作。 如果事务失败，MySQL就会按照**undo log**中的记录，逆序执行这些操作，把数据恢复到事务开始之前的状态。


!!! info "同步"

Master 同步 Slave, 读写分离 ， 故障切换， 高可用HA， 架构扩展

- 同步方式
    - 一主多从
    - 多主一从 
    - 双主复制
    - 级联复制(半同步)
        - Slave 通过 slave 同步，不直接与Master 同步


- 同步原理
    -  Master 启动 Log Dump Thread, read **bin log** and lock it, then release once complete reading
    -  Slave 启动 IO Thread , read **bin log** on Master and save it to **relay-log**
    -  Slave 启动 SQL Thread, read **relay log** and execute

  -    

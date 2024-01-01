---
date: 
    created: 2024-01-01

---


# WAL机制

Write-Ahead Logging，它的关键点就是日志先写内存，再写磁盘.
MySQL执行更新操作后，在真正把数据写入到磁盘前，先记录日志。

[MySQL](DB.md#mysql) redo log包括两部分内容，分别是内存中的日志缓冲([redo log](DB.md#redo-log
) buffer)和磁盘上的日志文件(redo log file)。

[MySQL](DB.md#mysql) 每执行一条DML语句，会先把记录写入redo log buffer，后续某个时间点再一次性将多个操作记录写到redo log file。这种先写日志，再写磁盘的技术，就是WAL。


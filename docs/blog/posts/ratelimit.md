---
date: 
    created: 2024-01-01

---

# [Rate Limit](https://juejin.cn/post/7209504489010430010?searchId=202401011520515375BF8CA32F8E95D53C)

固定窗口限流算法 Fixed Window Rate Limiting Algo

滑动窗口限流算法 : 单位时间周期分为n个小周期，分别记录每个小周期内接口的访问次数

漏桶限流算法 : Leaky Bucket Algo , 请求 判断是否达到当前 漏桶 Capacity， 是 refuse， 否 进行服务

令牌桶算法 : 维护一个固定容量的令牌桶，每秒钟会向令牌桶中放入一定数量的令牌。当有请求到来时，如果令牌桶中有足够的令牌，则请求被允许通过并从令牌桶中消耗一个令牌，否则请求被拒绝。



### [Nginx 限流](https://juejin.cn/post/7120044094239277070)

限制访问频率和限制并发连接数

```
ngx_http_limit_req_module

```

### [Redis 限流](https://juejin.cn/post/7033646189845151757)

基于Redis的setnx的操作

基于Redis的数据结构zset

基于Redis的令牌桶算法

### Sentinel 限流
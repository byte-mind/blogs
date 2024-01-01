---
date: 
    created: 2023-12-31

---

# Cloud Native

### "Intro"

满足云原生最佳技术实践和管理实践要求，应用从需求提出开始就使用云原生资源和服务能力，并最终能够持续交付到云平台的应用；同时在该应用交付完成后还需要具备足够的管控治理能力和可观测性。

Cloud Native 包含

- [微服务](Microservices.md)， 敏捷基础管理

- DevOps, [CI&CD](./ContinuousDelivery.md), Conways Law, etc

- 应用容器化 (software stack to be containerized)

- 面向微服务 (microservice oriented)

- 容器编排调度 (orchestrated)

- 服务网格 (service mesh)

```
微服务中分 侵入式架构和非侵入式架构
侵入式架构 - Dev 调用各种组件，如 RPC ，负载均衡，熔断等，业务代码与非功能性代码耦合
非侵入式架构 - Dev 关注业务代码， Service Mesh 关注其他非功能性
```

- 不可变基础设施 (Immuntable Infrastructure)


- 声明式API (declarative API)


### info "Why"

    | Req                  | Solution |
    | -------------------- | -------- |
    | 更快的上线需求       | CI&CD    |
    | 细致的故障探测和发现 | [微服务](Microservices.md)   |
    | 故障能自动隔离       | [微服务](Microservices.md)   |
    | 故障可以自动恢复     | [微服务](Microservices.md)   |
    | 水平扩容             | [微服务](Microservices.md)   |

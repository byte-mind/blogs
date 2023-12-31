---
date: 
    created: 2023-12-31
hide:
  - navigation
  - toc
---

# 服务容错

### Definition

系统依赖的某个服务发生延迟或者故障，数秒内导致所有应用资源（线程，队列等）被耗尽，造成所谓的雪崩效应 (Cascading Failure)，导致整个系统拒绝对外提供服务。

!!! info "principle"

    Design for failure

!!! info "Solution"

    Timeout & Retry 

    Rate limiting & Load Shield

    Circuit Breaker

    Bulkhead Isolation

    Fallback

        自定义处理

        fail-silent

        fail-fast
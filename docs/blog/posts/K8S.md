---
date: 
    created: 2024-01-01

---

# K8S


### [Service Mesh](https://istio.io/latest/about/service-mesh/)

Envoy：负责各个应用服务之间通信。
Pilot：管理和配置Envoy，提供服务发现、负载均衡和智能路由，保证弹性服务（服务超时次数、重试、熔断策略）。
Mixer：信息监控检查。
Istio-Auth：提供服务和服务、用户和服务之间的认证服务，实现访问控制，解决是谁访问的是哪个 API 的问题


### ETCD

是一个管理配置信息和服务发现（service discovery）的项目，它的目标是构建一个高可用的分布式键值（key-value）数据库.

### K8S 集群管理

Master节点:
```
Master节点运行着集群管理相关的一组进程kube-apiserver、kube-controller-manager和kube-scheduler，这些进程实现了整个集群的资源管理、Pod调度、弹性伸缩、安全控制、系统监控和纠错等管理能力，并且都是全自动完成
```
工作节点:
```
Kubernetes集群架构中运行Pod的服务节点
```
Pod
```
运行于Node节点上，若干相关容器的组合,Pod是Kurbernetes进行创建、调度和管理的最小单位,一个Pod可以包含一个容器或者多个相关容器。
```
静态pod
```
静态pod是由kubelet进行管理的仅存在于特定Node的Pod上，他们不能通过API Server进行管理，无法与ReplicationController、Deployment或者DaemonSet进行关联，并且kubelet无法对他们进行健康检查。静态Pod总是由kubelet进行创建，并且总是在kubelet所在的Node上运行。
```
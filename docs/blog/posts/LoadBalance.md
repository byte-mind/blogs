---
date: 
    created: 2024-01-04


---

# 负载均衡

LVS 是四层负载均衡，也就是说建立在 OSI 模型的第四层——传输层之上.
Nginx是一个七层的负载均衡器,所以效率势必比四层的LVS低很多,但是可操作性比LVS高.

#### Nginx 调度

round robin

weight

least connection

#### LVS 

https://tinychen.com/20200427-lvs-principle-introduction/





loadbalance：Load Balancer，负载均衡器，运行LVS负责负载均衡的服务器
DS：Director Server，指的是前端负载均衡器节点，也就是运行LVS的服务器；
RS：Real Server，后端真实的工作服务器；
VIP：Virtual Server IP，向外部直接面向用户请求，作为用户请求的目标的IP地址，一般也是DS的外部IP地址；
DIP：Director Server IP，主要用于和内部主机通讯的IP地址，一般也是DS的内部IP地址；
RIP：Real Server IP，后端服务器的IP地址；
CIP：Client IP，访问客户端的IP地址；


**NAT模式**

NAT模式的主要实现原理是通过网络地址转换，LB重写请求报文的目标地址(包括IP和MAC)，根据预设的调度算法，将请求分派给后端的RS；RS的响应报文通过LB返回时，报文的源地址被重写，修改为LB的MAC和IP，再返回给客户，完成整个负载调度过程

**IP Tunneling**
LB把请求报文通过IP隧道转发至RS，而RS将响应直接返回给客户端，所以LB只需要处理请求报文。由于一般网络服务应答的数据包要比请求数据包大许多，采用 VS/TUN技术后，集群系统的最大吞吐量可以大大提高。

**Direct Routing**


### 使用 Spring Social 开发第三方登录

OAuth 协议： 实际上是一个授权协议,在不将用户名密码第三方应用的情况下，经过用户的授权,来获取服务提供商上的一些用户资源

* Provider(服务提供商)
    * Authorization Server(认证服务器)
    * Resource Server(资源服务器)
* Resource Owner(资源所有者)
* Client(第三方应用)

OAuth 协议常规访问流程：
0. Resource Owner 访问 Client
1. Client 向 Resource Owner 请求授权
2. Resource OWner 同意授权
3. Client 向 Authorization Server 申请令牌
4. Authorization Server 发放令牌 给 Client
5. Client 获得令牌后向 Resource Server 申请资源
6. Resource Server 验证令牌正确 向 Client 发放资源


OAuth 协议中的授权模式：
* 授权码模式 (authorization code) 
* 密码模式 (resource owner password credentials)
* 客户端模式 (client credentials)
* 简化模式 (implicit)

授权码模式 访问流程：
0. Resource Owner 访问 Client
1. Client 将 Resource Owner 引导向 Authorization Server
2. Resource Owner 同意授权
3. Authorization Server 将授权码返回给 Client
4. Client 向 Authorization Server 申请令牌
5. Authorization Server 发放令牌 给 Client
6. Client 获得令牌后向 Resource Server 申请资源
7. Resource Server 验证令牌正确 向 Client 发放资源

跟常规的区别：同意授权是在认证服务器上完成的，更加的安全
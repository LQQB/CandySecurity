CandySecurity
==
使用 SpringSecurity 开发一个可重用认证授权模块
### 项目结构:这是一个maven架构的多模块项目
* candy-security(主模块):对下面四个子模块进行统一管理,可以对它们执行maven的命令跟打包以及测试 
* candy-security-core(核心业务模块):要实现基本的安全认证方式都是在这里实现
* candy-security-browser(浏览器相关模块):浏览器安全认证授权相关的特定代码
* candy-security-app(app相关模块):app安全认证授权相关的特定代码
* candy-security-demo(样例代码):

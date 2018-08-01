SpringSecurity 开发基于表单的认证
    1. 认证( 你是谁 )
    2. 授权( 你能干什么 )
    3. 攻击防护( 防止伪造身份 )

1.  SpringSecurity   的基本原理
    SpringSecurity 过滤器链:  当一个请求过来的时候,会经过springSecurity设置的多层的过滤器链,
           (如 UsernamePasswordAuthenticationFilter, BasicAuthenticationFilter等)一个过滤器一个过滤器往下走,
           每通过一个过滤器的认证就会添加在请求中添加一个标记,当通过前面所有过滤器链之后,会到一个叫
           FilterSecurityInterceptor 的拦截器中做最后的判断,而判断的依据就是我们的在代码中的配置,并且根据对应的
           原因抛出异常给一个叫 ExceptionTranslationFilter的过滤器,在这个过滤器中进行相应的处理
2.  实现用户名 +  密码认证
3.  实现手机号 +  短信认证


SpringSecurity 开发基于表单的认证
    1. 认证( 你是谁 )
    2. 授权( 你能干什么 )
    3. 攻击防护( 防止伪造身份 )

@EnableWebSecurity, 这个注解它本身毫无用处。 必须在实现WebSecurityConfigurer的bean中配置
Spring Security，或者（为方便起见）扩展WebSecurityConfigurerAdapter。 Spring应用程序上下
文中实现WebSecurityConfigurer的任何bean都可以为Spring Security配置


1.  SpringSecurity   的基本原理
    SpringSecurity 过滤器链:  当一个请求过来的时候,会经过springSecurity设置的多层的过滤器链,
           (如 UsernamePasswordAuthenticationFilter, BasicAuthenticationFilter等)一个过滤器一个过滤器往下走,
           每通过一个过滤器的认证就会添加在请求中添加一个标记,当通过前面所有过滤器链之后,会到一个叫
           FilterSecurityInterceptor 的拦截器中做最后的判断,而判断的依据就是我们的在代码中的配置,并且根据对应的
           原因抛出异常给一个叫 ExceptionTranslationFilter的过滤器,在这个过滤器中进行相应的处理

           自定义用户认证逻辑
                处理用户信息获取逻辑
                处理用户校验逻辑
                处理密码加密解密

                 UserDetailsService 接口,  由 SpringSecurity 提供,输入用户名,来读取用户信息UserDetails
                 User 类, 由 SpringSecurity 提供, 实现UserDetails接口
                 BCryptPasswordEncoder 类, 密码加密类

            个性化用户认证流程
                自定义登录页面
                自定义登录成功处理
                自定义登录失败处理

2.  实现用户名 +  密码认证
3.  实现手机号 +  短信认证


configur 基本配置

@Configuration 	这个就是java形式的bean spring3.0以后 允许以 @Configuration 注解来代替XML形式的bean
@EnableWebSecurity 	用这个注解开启 spring security配置验证开启
WebSecurityConfigurerAdapter 	这个需要我们继承WebSecurityConfigurerAdapter适配器且重写
 configure 函数 来实现访问的控制（那些访问/资源 需要哪些权限）和登录的验证（数据库验证/内存验证）
authorizeRequests() 	通过authorizeRequests()配下的子函来完成访问/授权 配置
antMatchers/permitAll 	antMatchers里配置的资源是可以被所有用户访问（permitAll）的
and() 	类似于结束标签
formLogin 	通过formLogin()配下的函数对登录form进行配置
loginPage 	设置登录页面
defaultSuccessUrl 	默认登录成功跳转地址
failureUrl 	默认登录失败跳转地址
usernameParameter
passwordParameter 	用户名密码验证用 *这里的参数要和画面上控件名保持一致
logout() 	通过logout()配下的函数对注销进行配置
logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 	设置注销用的请求URL
logoutSuccessUrl 	设置注销成功后的跳转URL
deleteCookies 	消除Cookie
invalidateHttpSession 	销毁Session
sessionManagement 	通过sessionManagement配下的函数对session配置
maximumSessions 	同一用户session上限设定 *比如同一个用户 多次登录
maxSessionsPreventsLogin 	maximumSessions设定的上限启用 * 超出报错
expiredUrl

超过session上限跳转URL设定


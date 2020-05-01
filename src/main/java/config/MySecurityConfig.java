package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

// spring security 配置

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 连接数据库
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from user where username = ?")
                .authoritiesByUsernameQuery("select username, authorities from roles where username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 自定义登陆页面为login.jsp，否则使用浏览器自带的登陆框。还要写一个jsp、一个controller方法，下面这一行只是指定了需要认证时的弹出框
                .formLogin().loginPage("/login")
                // 登出路径，在需要登出功能的jsp(hello.jsp)页面再添加一个a标签即可。不需要写controller，也不需要写jsp页面，因为退出成功后会走controller里的login方法、login.jsp页面
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                // 记住我，默认关闭浏览器cookie失效，设置时间后关闭浏览器再打开此网站不需要登陆
                .and().rememberMe().tokenValiditySeconds(2419200)
                // 认证规则
                .and().authorizeRequests()
                // 访问/hello需要密码
                .antMatchers("/hello").authenticated()
                // 访问/world需要认证，且角色需要是MEMBER
                .antMatchers("/world").hasRole("MEMBER")
                // 其它路径都不需要认证
                .anyRequest().permitAll()
                // 开启https，服务器还要安装SSL
                .and().requiresChannel()
                // 访问/receive需要https，这里要指定为post方法，在controller里要指定为get，先访问这里，spring security重定向为https的get请求就会走controller，否则会死循环访问这里
                .antMatchers(HttpMethod.POST, "/receive").requiresSecure()//.anyRequest().requiresInsecure()
                // 定义https端口号，服务器的SSL端口号需要定义为mapsTo()的参数
                .and().portMapper().http(80).mapsTo(8080)
                .and().httpBasic()
                // 禁用csrf攻击
                .and().csrf().disable();
    }
}


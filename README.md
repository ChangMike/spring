1. 数据源要定义在spring配置文件里，不能配置在springMVC的配置文件里
2. 定义数据源
3. 在MySecurityConfig重写方法
protected void configure(AuthenticationManagerBuilder auth){}
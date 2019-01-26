package cn.mypro.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cn.mypro")
@Import(value = {DaoConfiguration.class})
@PropertySource(value = {"classpath:db.properties"})
public class SpringConfiguration {

}

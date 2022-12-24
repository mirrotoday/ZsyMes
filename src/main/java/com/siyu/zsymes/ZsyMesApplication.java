package com.siyu.zsymes;

import cn.hutool.core.date.StopWatch;
import com.siyu.zsymes.utils.Print;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"com.siyu.zsymes", "com.siyu.zsymes.controller","com.siyu.zsymes.service"})
public class ZsyMesApplication {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        SpringApplication.run(ZsyMesApplication.class, args);
        stopWatch.stop();
        Print.out("ZsyMes接口已启动完毕，用时：%s ms",stopWatch.getTotalTimeMillis());
    }

}

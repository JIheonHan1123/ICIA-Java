package com.example.demo;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.*;

// 스프링 스케줄링 : 서버가 시간 조건에 따라 어떤 작업을 수행
//				 즉 병렬수행 ->Thread -> 몇개까지?

// Pool : 미리 확보해놓는다
// ConnectionPool : db에 연결을 미리 생성한다 -> Hikari
// ThreadPool : 스케줄링할 스레드를 미리 10개를 만들어라

@Configuration
@EnableScheduling
public class ScheduleConfig {
	@Bean
	TaskScheduler getTaskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(10);
		return scheduler;
	}
}

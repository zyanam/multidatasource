package org.example.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@SpringBootApplication
public class AppStartup implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AppStartup.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    JdbcTemplate secondJdbcTemplate;

    @Autowired
    @Qualifier("thirdJdbcTemplate")
    JdbcTemplate thirdJdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM public.job limit 1";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        System.out.println(stringObjectMap.toString());


        sql = "select * from public.psutillog limit 1";
        Map<String, Object> stringObjectMap1 = secondJdbcTemplate.queryForMap(sql);
        System.out.println(stringObjectMap1);

        sql = "select * from lte_pm_eutrancellfdd limit 1";
        Map<String, Object> stringObjectMap2 = thirdJdbcTemplate.queryForMap(sql);
        System.out.println(stringObjectMap2);
    }
}

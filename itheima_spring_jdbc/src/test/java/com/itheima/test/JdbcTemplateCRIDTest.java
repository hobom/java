package com.itheima.test;


import com.itheima.damain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//这种写法是为了让测试在Spring容器环境下执行,
// 比如常见的 Service  Dao  Action ， 这些个东西，都在Spring容器里，junit需要将他们拿到，并且使用来测试。
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRIDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQuerryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account",Long.class);
        System.out.println(count);
    }

    @Test
    public void testQuerryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "zhangsan");
        System.out.println(account);
    }

    @Test
    public void testQuerryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",10000,"tom");
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?","tom");
    }
}

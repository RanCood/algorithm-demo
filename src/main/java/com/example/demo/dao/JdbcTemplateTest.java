package com.example.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zg
 * @date 2019/2/15 14:22
 */
@RestController
@Slf4j
public class JdbcTemplateTest {

    @Resource
    private JdbcTemplate guardJdbcTemplate;

    @Resource
    private JdbcTemplate ruleJdbcTemplate;

    @GetMapping("/foo")
    public List foo() {
        List<Foo> list = guardJdbcTemplate.query("select * from foo where id=1", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet resultSet, int i) throws SQLException {
                Foo foo = new Foo();
                foo.setId(resultSet.getLong("id"));
                foo.setName(resultSet.getString("name"));
                return foo;
            }
        });
        log.info("foo info {}", list.toString());
        return list;
    }

    @GetMapping("/bar")
    public List bar() {
        List<Bar> list = ruleJdbcTemplate.query("select * from bar where id=1", new RowMapper<Bar>() {
            @Override
            public Bar mapRow(ResultSet resultSet, int i) throws SQLException {
                Bar bar = new Bar();
                bar.setId(resultSet.getLong("id"));
                bar.setAge(resultSet.getInt("age"));
                return bar;
            }
        });
        log.info("bar info {}", list.toString());
        return list;
    }
}

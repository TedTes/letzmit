package com.tutego.date4u.shell;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.slf4j.*;

@ShellComponent
public class JdbcCommands {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    private Logger log = LoggerFactory.getLogger(getClass());

    public JdbcCommands(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ShellMethod("Display mane length of a given profile by nickname")
    public String manelength(String nickname) {
        try {
            log.info(dataSource.getConnection().getClass().getName());
        } catch (Exception e) {
            System.out.println(e);
        }

        String sql = "SELECT manelength FROM Profile WHERE nickname = ?";
        List<Integer> lengths = jdbcTemplate.queryForList(sql, Integer.class,
                nickname);
        return lengths.isEmpty() ? "Unknown profile for nickname " + nickname
                : lengths.get(0).toString();
    }
}

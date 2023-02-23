package com.nttdata.monitor.DAO;

import com.nttdata.monitor.dominio.Monitor;
import com.nttdata.monitor.mapper.MonitorRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;


@Repository
public class MonitorDaoJdbc {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MonitorDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Monitor> findAll() {
        return jdbcTemplate.query("SELECT * FROM monitor", new MonitorRowMapper());
    }

    public Monitor findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM monitor WHERE id = ?", new Object[] { id }, new MonitorRowMapper());
    }

    public void save(Monitor monitor) {
        jdbcTemplate.update("INSERT INTO monitor (marca, colore) VALUES (?, ?)", monitor.getMarca(), monitor.getColore());
    }

    public void update(Monitor monitor) {
        jdbcTemplate.update("UPDATE monitor SET marca = ?, colore = ? WHERE id = ?", monitor.getMarca(), monitor.getColore(), monitor.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM monitor WHERE id = ?", id);
    }

}


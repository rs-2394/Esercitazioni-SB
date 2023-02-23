package com.nttdata.monitor.mapper;



import com.nttdata.monitor.dominio.Monitor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonitorRowMapper implements RowMapper<Monitor> {
    @Override
    public Monitor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String marca = rs.getString("marca");
        String colore = rs.getString("colore");
        return new Monitor(id, marca, colore);
    }
}

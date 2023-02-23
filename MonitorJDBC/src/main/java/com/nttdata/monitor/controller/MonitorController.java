package com.nttdata.monitor.controller;

import com.nttdata.monitor.DAO.MonitorDaoJdbc;
import com.nttdata.monitor.dominio.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    MonitorDaoJdbc monitorDao;

    @GetMapping
    public ResponseEntity<List<Monitor>> list() {
        return new ResponseEntity<>(monitorDao.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Monitor> create (@RequestBody Monitor monitor){
        monitorDao.save(monitor);
        return new ResponseEntity<> (HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Monitor monitor) {
        monitor.setId(id);
        monitorDao.update(monitor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monitorDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

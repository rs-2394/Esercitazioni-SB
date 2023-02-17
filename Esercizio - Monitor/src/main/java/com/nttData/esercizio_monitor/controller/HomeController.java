package com.nttData.esercizio_monitor.controller;

import com.nttData.esercizio_monitor.Monitor.Televisore;
import com.nttData.esercizio_monitor.Monitor.Monitor;
import com.nttData.esercizio_monitor.Monitor.MonitorUfficio;
import com.nttData.esercizio_monitor.Monitor.Canale.Canale;
import com.nttData.esercizio_monitor.Monitor.Canale.EState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@RestController
public class HomeController {

    @GetMapping("/tv")
    public ResponseEntity<Televisore> getTelevisore() {

        Televisore televisore =
                new Televisore("Nero","Samsung", LocalTime.now(),new Canale("italiaUno", 6, EState.SELECTED));

        return new ResponseEntity<Televisore>(televisore, HttpStatus.OK);
    }

    @PutMapping("/monitor/{id}")
    public ResponseEntity<?> updateMonitor(@PathVariable("id") long id_monitor, @RequestBody Monitor monitor) {
        Monitor monitor1 = new Monitor("Grigio Siderale", "LG", 001);
        if (monitor1.getId() == id_monitor) return new ResponseEntity<>(monitor1, HttpStatus.CREATED);
        return new ResponseEntity<>(monitor, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/monitor/{id}")
    public ResponseEntity<?> deleteMonitor(@PathVariable long id) {
        System.out.println("Monitor: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/monitorUfficio1")
    public ResponseEntity<MonitorUfficio> getMonitorUfficio() {
        Set<String> inputs = new HashSet<>();
        inputs.add("Off");
        MonitorUfficio monitorUfficio = new MonitorUfficio("Rosso", "LG", inputs);
        return new ResponseEntity<MonitorUfficio>(monitorUfficio, HttpStatus.OK);
    }
    @PostMapping("/MonitorUfficio")
    public ResponseEntity<?> createMonitorUfficio (@RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 =monitorUfficio;
        return new ResponseEntity<>(monitorUfficio1, HttpStatus.CREATED);
    }

    @PutMapping("/canale/{numero}")
    public ResponseEntity<?> updateCanale(@PathVariable("numero") long numero_canale, @RequestBody Canale canale) {
        Canale canale1 = new Canale("TV8", 8, EState.SELECTED);
        if (canale1.getNumero() == numero_canale)
            return new ResponseEntity<>(canale1, HttpStatus.CREATED);
        return new ResponseEntity<>(canale, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/risintonizza")
    public ResponseEntity<?> risintonizzaCanali() {
        Televisore tv = new Televisore("Blu", "Sony", LocalTime.now(), new Canale("Rai 1", 1, EState.SELECTED), new Canale("Italia1", 6, EState.NOT_SELECTED));
        tv.risintonizza();
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }

    @DeleteMapping("/rimuovicanale")
    public ResponseEntity<?> deletecanale(@PathVariable long numero) {
        System.out.println("Canale " + numero);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/aggiungicanale")
    public ResponseEntity<?> createCanale (@RequestBody Canale canale){
        Canale canale1 = canale;
        return new ResponseEntity<>(canale1, HttpStatus.CREATED);
    }

}


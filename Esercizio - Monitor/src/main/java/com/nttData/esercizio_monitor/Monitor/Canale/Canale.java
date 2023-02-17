package com.nttData.esercizio_monitor.Monitor.Canale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canale {

    private String nome;
    private long numero;
    private EState state;
}

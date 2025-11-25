
# Bucigno Gara Cavalli

Simulatore di corsa di cavalli multi-thread in Java che permette di gestire una gara virtuale con possibilità di salvare i risultati su file.

## Descrizione

Questo progetto implementa una simulazione di corsa di cavalli utilizzando i thread Java. Ogni cavallo corre in un thread separato e il primo che completa i 10 passi vince la gara. Il programma offre un'interfaccia testuale per gestire i cavalli e la corsa, con la possibilità di salvare i risultati tramite una finestra di dialogo grafica.

## Funzionalità

- **Inserimento cavalli**: Aggiungi cavalli alla gara specificando il loro nome
- **Configurazione velocità**: Imposta il tempo di sleep per ogni cavallo (determina la velocità)
- **Avvio corsa**: Fai partire la gara con tutti i cavalli inseriti
- **Azzoppa cavallo**: Interrompi casualmente un cavallo durante la corsa
- **Salvataggio risultati**: Salva il vincitore su file tramite JFileChooser

## Struttura del Progetto

```
src/
├── Main.java              # Classe principale con menu e gestione della gara
├── Cavallo.java           # Classe Thread che rappresenta un cavallo
└── FileChooserDemo.java   # Demo Oracle per JFileChooser (riferimento)
```

## Componenti Principali

### Main.java
Classe principale che gestisce:
- Menu interattivo a console
- Lista dei cavalli partecipanti
- Coordinamento della gara
- Salvataggio risultati su file con dialog grafico

### Cavallo.java
Estende Thread e implementa:
- Simulazione della corsa (10 passi)
- Gestione interruzioni (azzoppamento)
- Sincronizzazione per determinare il vincitore

## Come Usare

### Compilazione
```bash
javac src/*.java
```

### Esecuzione
```bash
java -cp src Main
```

### Menu Opzioni

1. **Insert horse**: Inserisci un nuovo cavallo specificando il nome
2. **Insert sleepTime**: Imposta il tempo di sleep (ms) per un cavallo specifico
3. **Start the race**: Avvia la corsa con i cavalli configurati
4. **Azzoppa un cavallo**: Interrompe casualmente un cavallo in corsa
5. **Exit**: Esce dal programma

### Esempio di Utilizzo

```
1. Inserisci cavallo "Furia"
2. Inserisci cavallo "Lampo"
3. Inserisci cavallo "Saetta"
4. Imposta sleepTime 100ms per "Furia"
5. Imposta sleepTime 150ms per "Lampo"
6. Imposta sleepTime 120ms per "Saetta"
7. Avvia la corsa
8. Salva il risultato quando richiesto
```

## Requisiti

- Java JDK 8 o superiore

## Dettagli Tecnici

### Threading
Ogni cavallo corre in un thread separato. La sincronizzazione è gestita tramite:
- `synchronized` block su `Main.class` per determinare il primo arrivato
- `Thread.join()` per attendere il completamento di tutti i thread

### Gestione Interruzioni
I cavalli possono essere "azzoppati" (interrotti) durante la corsa tramite `Thread.interrupt()`. Quando un cavallo viene interrotto, esce dalla corsa stampando un messaggio.

### Salvataggio File
Utilizza `JFileChooser` per permettere all'utente di scegliere dove salvare il risultato della gara in formato testo.

## Note

- Il tempo di sleep determina la velocità del cavallo (valori più bassi = cavallo più veloce)
- Se non viene impostato un sleepTime, il valore predefinito è 0
- La gara crea nuove istanze dei cavalli per evitare conflitti tra corse multiple
- Il vincitore è il primo cavallo che completa i 10 passi

#
## Licenza

progettoa scopo didattico

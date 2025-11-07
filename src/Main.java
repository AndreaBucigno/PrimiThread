import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*; // Per JFileChooser

/**
 * La classe {@code Main} rappresenta il punto di ingresso del programma che simula una corsa tra cavalli.
 * <p>
 * L'utente può inserire cavalli, impostare il loro tempo di attesa (sleep time),
 * avviare la corsa, azzoppare casualmente un cavallo o salvare il risultato su file.
 * </p>
 *
 * <p>Il programma utilizza la classe {@link Cavallo} per rappresentare ogni partecipante alla corsa,
 * eseguita tramite thread paralleli.</p>
 *
 * <p>Funzionalità principali:</p>
 * <ul>
 *   <li>Inserimento di nuovi cavalli</li>
 *   <li>Impostazione del tempo di corsa per ogni cavallo</li>
 *   <li>Avvio della corsa con sincronizzazione del vincitore</li>
 *   <li>Simulazione di cavalli azzoppati (interrotti)</li>
 *   <li>Salvataggio del risultato su file tramite {@link JFileChooser}</li>
 * </ul>
 *
 * @author
 * @version 1.0
 */
public class Main {

    /** Nome del cavallo vincitore della corsa. */
    static String first;

    /**
     * Metodo principale che gestisce l'interazione con l'utente e le varie opzioni del menu.
     *
     * @param args argomenti della riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean x = true;
        ArrayList<Cavallo> horses = new ArrayList<>();
        int condition;

        while (x) {
            System.out.println("__________________________________________________________________________");
            System.out.println("1.Insert horse \n2.Insert sleepTime \n3.Start the race\n4.Azzoppa un cavallo\n5.Exit");
            System.out.println("Enter the option:");
            condition = scanner.nextInt();
            scanner.nextLine();

            switch (condition) {
                case 1:
                    // Inserisce un nuovo cavallo nella lista
                    System.out.println("Enter the horse name:");
                    String horseName = scanner.nextLine();
                    horses.add(new Cavallo(horseName));
                    break;

                case 2:
                    // Imposta il tempo di corsa per un cavallo esistente
                    int i = 1;
                    System.out.println("Horse List:");
                    for (Cavallo c : horses) {
                        System.out.println(i++ + " " + c.getHorseName());
                    }
                    System.out.println("Insert name of horse:");
                    String name = scanner.nextLine();
                    System.out.println("Insert the sleep time:");
                    int sleepTime = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Cavallo c : horses) {
                        if (c.getHorseName().equals(name)) {
                            c.setSleepTime(sleepTime);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Horse not found.");
                    }
                    break;

                case 3:
                    // Avvia la corsa
                    if (horses.isEmpty()) {
                        System.out.println("No horses in the race!");
                        break;
                    }

                    Main.first = null;

                    ArrayList<Cavallo> race = new ArrayList<>();
                    for (Cavallo c : horses) {
                        race.add(new Cavallo(c.getHorseName()));  // nuova istanza per ogni cavallo
                        race.get(race.size() - 1).setSleepTime(c.getSleepTime());
                    }

                    for (Cavallo c : race) {
                        c.start();
                    }
                    for (Cavallo c : race) {
                        try {
                            c.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("The winner is: " + first);

                    // Dopo la corsa, chiede dove salvare il risultato
                    salvaRisultatoSuFile("The winner is: " + first);
                    break;

                case 4:
                    // Azzoppa (interrompe) un cavallo scelto casualmente
                    if (!horses.isEmpty()) {
                        int rand = (int) (Math.random() * horses.size());
                        horses.get(rand).setInterrupt();
                        System.out.println(horses.get(rand).getHorseName() + " è stato azzoppato!");
                    }
                    break;

                case 5:
                    // Esce dal programma
                    x = false;
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Imposta il nome del cavallo vincitore.
     * Metodo sincronizzato per evitare accessi concorrenti da più thread.
     *
     * @param t nome del cavallo vincitore
     */
    public static synchronized void setFirst(String t) {
        first = t;
    }

    /**
     * Restituisce il nome del cavallo vincitore.
     * Metodo sincronizzato per garantire la consistenza dei dati.
     *
     * @return nome del cavallo vincitore
     */
    public static synchronized String getFirst() {
        return first;
    }

    /**
     * Mostra una finestra di dialogo per scegliere dove salvare il risultato della corsa
     * e scrive il testo specificato nel file selezionato.
     *
     * @param testo testo da salvare nel file
     */
    public static void salvaRisultatoSuFile(String testo) {
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Scegli dove salvare il risultato");

            int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(testo);
                    System.out.println("Risultato salvato in: " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Errore nel salvataggio: " + e.getMessage());
                }
            } else {
                System.out.println("Salvataggio annullato.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

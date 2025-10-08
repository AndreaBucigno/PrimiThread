import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner tastiera= new Scanner(System.in);
        System.out.println("quante pecore dovrai contare per addormentarti?....");
        int count= tastiera.nextInt(); //.nextLine() per leggere la riga
        //singolo thread
        ContaPecore thr1 = new ContaPecore(count);
        thr1.start();

        //thread padre è sveglio
        for (int i = 0; i < 100; i++) {
            System.out.println((i + 1) + " sono sveglio ");
        }
    }
}

class ContaPecore extends Thread {
    //variabile privata
    private final int num_pecore;
    //costruttore
    public ContaPecore(int num){
        super();
        num_pecore=num;
    }
    @Override
    public void run() {
        setName("thread conta pecorelle");
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < num_pecore; i++) {
            System.out.println((i + 1) + " pecore ");
        }
    }
}
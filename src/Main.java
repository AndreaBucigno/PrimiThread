import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean x;
        int number;

        Cavallo pazzo = new Cavallo("pazzo");
        Cavallo bianco = new Cavallo("bianco");
        Cavallo piero = new Cavallo("piero");
        Cavallo daniele = new Cavallo("daniele");
        Cavallo marcello = new Cavallo("marcello");

            System.out.println("SleepTime per " + pazzo.HorseName());
            pazzo.setSleepTime(scanner.nextInt());
            scanner.nextLine();

            System.out.println("SleepTime per " + bianco.HorseName());
            bianco.setSleepTime(scanner.nextInt());
            scanner.nextLine();

            System.out.println("SleepTime per " + piero.HorseName());
            piero.setSleepTime(scanner.nextInt());
            scanner.nextLine();

            System.out.println("SleepTime per " + daniele.HorseName());
            daniele.setSleepTime(scanner.nextInt());
            scanner.nextLine();

            System.out.println("SleepTime per " + marcello.HorseName());
            marcello.setSleepTime(scanner.nextInt());
            scanner.nextLine();

        pazzo.start();
        bianco.start();
        piero.start();
        daniele.start();
        marcello.start();


    }
}

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static String first;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean x=true;
        ArrayList<Cavallo> horses = new ArrayList<>();
        int condition;

        while(x){

                System.out.println("1.Insert horse \n2.Insert sleepTime \n3.Start the race\n4.Exit");
                System.out.println("enter the option:");
                condition = scanner.nextInt();
                scanner.nextLine();

                switch (condition){
                    case 1:
                        System.out.println("Enter the horse name:");
                        String horseName = scanner.nextLine();
                        horses.add(new Cavallo(horseName));
                        break;
                    case 2:
                        int i = 1;
                        System.out.println("Horse List:");
                        for (Cavallo c : horses){
                            System.out.println(i+" " +c.HorseName());
                        }
                        System.out.println("Insert name of horse:");
                        String name = scanner.nextLine();
                        System.out.println("Insert the sleep time:");
                        int sleepTime = scanner.nextInt();
                        scanner.nextLine();
                        for (Cavallo c : horses){
                            if(c.getName().equals(name)){
                                c.setSleepTime(sleepTime);
                                break;
                            }
                            continue;
                        }
                        break;
                    case 3:
                        for(Cavallo c : horses){
                            c.start();
                        }
                        break;

                    case 4 :
                        x = false;
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }

        }

    }
}

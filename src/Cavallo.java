/*
Questa classe è il nostro primo thread e consentirà la simulazione di un cavallo in corsa
parallelamenye con altri della stessa specie
@author user
@version jdk 1.0
 */

public class Cavallo extends Thread {

    private final String name;
    private int sleepTime;

        public Cavallo(String name){
        super();
        this.name = name;
    }

    @Override
    public void run(){

        System.out.println("cavallo " + name);
        for(int i = 1; i<=10;i++){
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " cavalca - passo " +i);
        }
    }

    protected int getSleepTime(){
            return sleepTime;
    }

    protected void setSleepTime(int sleepTime){
            this.sleepTime = sleepTime;
    }


    public String HorseName(){
            return name;
    }

}


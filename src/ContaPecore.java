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
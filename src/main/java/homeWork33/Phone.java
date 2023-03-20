package homeWork33;

public class Phone {
    long number;
    SimCard sim;

    public Phone(int number) {
        this.number = number;
    }

    public void inputSim(SimCard sim) {
        this.sim = sim;
        System.out.println(sim.getClass().getSimpleName() + " card was inserted");
    }

    public void call() {
        if (sim != null) {
            sim.connect();
        } else {
            System.out.println("Telephone doesn't have sim card.");
        }
    }

    public long getNumber() {
        return number;
    }
}

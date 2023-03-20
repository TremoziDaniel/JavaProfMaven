package homeWork33;

import java.util.concurrent.ThreadLocalRandom;

public class User {
    public static void main(String[] args) {
        Phone phone = new Phone(ThreadLocalRandom.current().nextInt(100000000, 999999999 + 1));
        System.out.println(phone.getNumber());
        SimCard beeSim = new BeeSim();
        SimCard starSim = new StarSim();
        phone.call();
        phone.inputSim(beeSim);
        phone.call();
        phone.inputSim(starSim);
        phone.call();
    }
}

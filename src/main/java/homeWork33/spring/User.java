package homeWork33.spring;

import homeWork33.BeeSim;
import homeWork33.Phone;
import homeWork33.SimCard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class User {
    public static void main(String[] args) {
        ApplicationContext appCont = new AnnotationConfigApplicationContext(AppConfig.class);

        Phone phone = appCont.getBean("getPhone", Phone.class);
        phone.call();

        SimCard beeSim = appCont.getBean("beeSim", BeeSim.class);
        phone.inputSim(beeSim);
        phone.call();
    }
}

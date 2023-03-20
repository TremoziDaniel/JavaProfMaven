package homeWork33.spring;

import homeWork33.BeeSim;
import homeWork33.Phone;
import homeWork33.SimCard;
import homeWork33.StarSim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class AppConfig {
    @Bean
    public SimCard beeSim() {
        return new BeeSim();
    }

    @Bean
    public SimCard starSim() {
        return new StarSim();
    }

    @Bean
    public Phone getPhone(SimCard starSim) {
        Phone phone = new Phone(ThreadLocalRandom.current().nextInt(100000000, 999999999 + 1));
        phone.inputSim(starSim);
        return phone;
    }
}

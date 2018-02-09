package com.mayweather.hearthstone;

import com.mayweather.hearthstone.services.BoosterService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HearthstoneApplication  {


    public static void main(String[] args) {
        SpringApplication.run(HearthstoneApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
        OrderDetails orderDetails = new OrderDetails(1L, 10, 19, 0);
        Order order = new Order(1L, orderDetails);
        orderService.save(order);
        Booster nickchipper = new Booster(2L, "Nikolaj", "Apasny guy", 1L, LocalDate.now(), Status.AVAILABLE, null);
        Booster drHippi = new Booster(3L, "Temka", "Veri bad guy", 2L, LocalDate.now(), Status.AVAILABLE, null);
        List<Order> orders = Collections.singletonList(order);
        Booster mayweather = new Booster(1L, "Pashka", "Veri gut guy", 20000L, LocalDate.now(), Status.AVAILABLE, orders);
        boosterService.save(mayweather);
        boosterService.save(nickchipper);
        boosterService.save(drHippi);


    }
    */
}

package stmalljso.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmalljso.DeliveryApplication;
import stmalljso.domain.Deliverycancelled;
import stmalljso.domain.Deliverystarted;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderid;

    private Long productid;

    private String prodectname;

    private Integer qty;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Deliverystarted deliverystarted = new Deliverystarted(this);
        deliverystarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Deliverycancelled deliverycancelled = new Deliverycancelled(this);
        deliverycancelled.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void deliveryStart(Orderplaced orderplaced) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        Deliverystarted deliverystarted = new Deliverystarted(delivery);
        deliverystarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            Deliverystarted deliverystarted = new Deliverystarted(delivery);
            deliverystarted.publishAfterCommit();

         });
        */

    }

    public static void deliveryCancel(Ordercancelled ordercancelled) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        Deliverycancelled deliverycancelled = new Deliverycancelled(delivery);
        deliverycancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordercancelled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            Deliverycancelled deliverycancelled = new Deliverycancelled(delivery);
            deliverycancelled.publishAfterCommit();

         });
        */

    }
}

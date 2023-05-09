package stmalljso.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmalljso.ProductApplication;
import stmalljso.domain.Stockdescrised;
import stmalljso.domain.Stockincreased;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productname;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        Stockdescrised stockdescrised = new Stockdescrised(this);
        stockdescrised.publishAfterCommit();

        Stockincreased stockincreased = new Stockincreased(this);
        stockincreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = ProductApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void deliveryStart(Deliverystarted deliverystarted) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        Stockdescrised stockdescrised = new Stockdescrised(inventory);
        stockdescrised.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliverystarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            Stockdescrised stockdescrised = new Stockdescrised(inventory);
            stockdescrised.publishAfterCommit();

         });
        */

    }

    public static void deliveryCancel(Deliverycancelled deliverycancelled) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        Stockincreased stockincreased = new Stockincreased(inventory);
        stockincreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliverycancelled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            Stockincreased stockincreased = new Stockincreased(inventory);
            stockincreased.publishAfterCommit();

         });
        */

    }
}

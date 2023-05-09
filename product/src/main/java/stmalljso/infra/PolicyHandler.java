package stmalljso.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmalljso.config.kafka.KafkaProcessor;
import stmalljso.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverystarted'"
    )
    public void wheneverDeliverystarted_DeliveryStart(
        @Payload Deliverystarted deliverystarted
    ) {
        Deliverystarted event = deliverystarted;
        System.out.println(
            "\n\n##### listener DeliveryStart : " + deliverystarted + "\n\n"
        );

        // Sample Logic //
        Inventory.deliveryStart(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCancelled'"
    )
    public void wheneverDeliveryCancelled_DeliveryCancel(
        @Payload DeliveryCancelled deliveryCancelled
    ) {
        DeliveryCancelled event = deliveryCancelled;
        System.out.println(
            "\n\n##### listener DeliveryCancel : " + deliveryCancelled + "\n\n"
        );

        // Sample Logic //
        Inventory.deliveryCancel(event);
    }
}

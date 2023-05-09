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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_DeliveryStart(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener DeliveryStart : " + orderplaced + "\n\n"
        );

        // Comments //
        //1. cj logis send paylod
        // 2. sns to customer
        // 3. keeping to our db

        // Sample Logic //
        Delivery.deliveryStart(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercancelled'"
    )
    public void wheneverOrdercancelled_DeliveryCancel(
        @Payload Ordercancelled ordercancelled
    ) {
        Ordercancelled event = ordercancelled;
        System.out.println(
            "\n\n##### listener DeliveryCancel : " + ordercancelled + "\n\n"
        );

        // Sample Logic //
        Delivery.deliveryCancel(event);
    }
}

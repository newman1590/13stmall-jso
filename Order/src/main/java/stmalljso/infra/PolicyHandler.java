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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Stockincreased'"
    )
    public void wheneverStockincreased_NotityToWaitingUser(
        @Payload Stockincreased stockincreased
    ) {
        Stockincreased event = stockincreased;
        System.out.println(
            "\n\n##### listener NotityToWaitingUser : " +
            stockincreased +
            "\n\n"
        );

        // Sample Logic //
        Order.notityToWaitingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverystarted'"
    )
    public void wheneverDeliverystarted_UpdateStatus(
        @Payload Deliverystarted deliverystarted
    ) {
        Deliverystarted event = deliverystarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverystarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverycancelled'"
    )
    public void wheneverDeliverycancelled_UpdateStatus(
        @Payload Deliverycancelled deliverycancelled
    ) {
        Deliverycancelled event = deliverycancelled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverycancelled + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}

package stmalljso.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmalljso.config.kafka.KafkaProcessor;
import stmalljso.domain.*;

@Service
public class MypageViewHandler {

    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderplaced_then_CREATE_1(
        @Payload Orderplaced orderplaced
    ) {
        try {
            if (!orderplaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setOrderid(orderplaced.getId());
            mypage.setUserid(orderplaced.getUserid());
            mypage.setProductname(orderplaced.getProductname());
            mypage.setQty(orderplaced.getQty());
            mypage.setProductid(orderplaced.getProductid());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliverystarted_then_UPDATE_1(
        @Payload Deliverystarted deliverystarted
    ) {
        try {
            if (!deliverystarted.validate()) return;
            // view 객체 조회

            List<Mypage> mypageList = mypageRepository.findByOrderid(
                deliverystarted.getOrderid()
            );
            for (Mypage mypage : mypageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus(Long.valueOf(deliverystarted.getStatus()));
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliverycancelled_then_UPDATE_2(
        @Payload Deliverycancelled deliverycancelled
    ) {
        try {
            if (!deliverycancelled.validate()) return;
            // view 객체 조회

            List<Mypage> mypageList = mypageRepository.findByOrderid(
                deliverycancelled.getOrderid()
            );
            for (Mypage mypage : mypageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus(Long.valueOf(deliverycancelled.getStatus()));
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package stmalljso.domain;

import java.util.*;
import lombok.*;
import stmalljso.domain.*;
import stmalljso.infra.AbstractEvent;

@Data
@ToString
public class Deliverystarted extends AbstractEvent {

    private Long id;
    private Long orderid;
    private Long productid;
    private String prodectname;
    private Integer qty;
    private String status;

    public Deliverystarted(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverystarted() {
        super();
    }
}

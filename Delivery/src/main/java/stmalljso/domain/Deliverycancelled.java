package stmalljso.domain;

import java.util.*;
import lombok.*;
import stmalljso.domain.*;
import stmalljso.infra.AbstractEvent;

@Data
@ToString
public class Deliverycancelled extends AbstractEvent {

    private Long id;
    private Long orderid;
    private Long productid;
    private String prodectname;
    private Integer qty;
    private String status;

    public Deliverycancelled(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverycancelled() {
        super();
    }
}

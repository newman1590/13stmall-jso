package stmalljso.domain;

import java.util.*;
import lombok.*;
import stmalljso.domain.*;
import stmalljso.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productname;
    private Long productid;
    private Long userid;
    private Integer qty;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}

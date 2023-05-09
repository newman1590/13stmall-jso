package stmalljso.domain;

import java.util.*;
import lombok.Data;
import stmalljso.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productname;
    private Long productid;
    private Long userid;
    private Integer qty;
}

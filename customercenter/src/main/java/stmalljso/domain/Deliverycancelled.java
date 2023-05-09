package stmalljso.domain;

import java.util.*;
import lombok.Data;
import stmalljso.infra.AbstractEvent;

@Data
public class Deliverycancelled extends AbstractEvent {

    private Long id;
    private Long orderid;
    private Long productid;
    private String prodectname;
    private Integer qty;
    private String status;
}

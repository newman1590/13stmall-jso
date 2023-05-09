package stmalljso.domain;

import java.util.*;
import lombok.*;
import stmalljso.domain.*;
import stmalljso.infra.AbstractEvent;

@Data
@ToString
public class Stockdescrised extends AbstractEvent {

    private Long id;
    private Long productname;
    private Integer stock;

    public Stockdescrised(Inventory aggregate) {
        super(aggregate);
    }

    public Stockdescrised() {
        super();
    }
}

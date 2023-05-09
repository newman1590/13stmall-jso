package stmalljso.domain;

import java.util.*;
import lombok.*;
import stmalljso.domain.*;
import stmalljso.infra.AbstractEvent;

@Data
@ToString
public class Stockincreased extends AbstractEvent {

    private Long id;
    private String productname;
    private Integer stock;
}

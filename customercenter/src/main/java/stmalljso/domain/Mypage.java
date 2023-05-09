package stmalljso.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Mypage_table")
@Data
public class Mypage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long orderid;
    private Long userid;
    private String productname;
    private Long productid;
    private Integer qty;
    private Long status;
}

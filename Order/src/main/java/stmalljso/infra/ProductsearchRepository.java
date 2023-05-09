package stmalljso.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmalljso.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "productsearches",
    path = "productsearches"
)
public interface ProductsearchRepository
    extends PagingAndSortingRepository<Productsearch, Long> {}

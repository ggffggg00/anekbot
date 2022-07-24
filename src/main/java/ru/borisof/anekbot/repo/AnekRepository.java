package ru.borisof.anekbot.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.borisof.anekbot.domain.Anek;

public interface AnekRepository extends CrudRepository<Anek, Long> {

    @Query(value = "SELECT * FROM ab_anek ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Anek findRandomAnek();


}

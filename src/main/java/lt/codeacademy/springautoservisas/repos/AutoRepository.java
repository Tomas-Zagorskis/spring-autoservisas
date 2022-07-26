package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.Auto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface AutoRepository extends JpaRepository<Auto, UUID> {


        @Query("select a from Auto a where lower(a.brand) like lower(concat('%',:keyword,'%'))" +
            " or lower(a.model) like lower(concat('%',:keyword,'%'))" +
            " or lower(a.plateNr) like lower(concat('%',:keyword,'%'))")
    Page<Auto> findByKeyword(Pageable pageable, @Param("keyword") String keyword);


    Auto findAutoByPlateNr(String id);

    @Modifying
    @Transactional
    @Query("delete from Auto a where a.plateNr = :plateNr")
    void reclaimAuto(String plateNr);


}

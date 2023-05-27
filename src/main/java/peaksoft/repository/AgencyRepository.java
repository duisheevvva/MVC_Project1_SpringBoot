package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.exception.MyException;

import java.util.List;
import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency,Long> {
    @Query("select u from Agency u where u.name ilike :word")
    List<Agency> searchHouse(String word);

}


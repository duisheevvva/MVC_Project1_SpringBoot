package peaksoft.service;

import peaksoft.entity.Agency;
import peaksoft.exception.MyException;

import java.util.List;

public interface AgencyService {
    void saveAgency(Agency agency);

    List<Agency> getAllAgency();

    Agency getById(Long id);

    void updateAgencyById(Long id,Agency agency) throws MyException;

    void deleteById(Long id);
    List<Agency> searchAgency(String word);
}

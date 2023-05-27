package peaksoft.service;

import peaksoft.entity.House;
import peaksoft.exception.MyException;

import java.util.List;

public interface HouseService {
    void saveHouse(Long agencyId,House house);
    List<House> getAllHouse(Long agencyId,String word) throws MyException;
    House getHouseById(Long id) throws MyException;
    House updateHouseById(Long id,House house);
    void deleteHouseById(Long id) ;
    List<House> sortHouseByHouseType(String ascOrDesc);
    List<House> searchHouse(String word);
}

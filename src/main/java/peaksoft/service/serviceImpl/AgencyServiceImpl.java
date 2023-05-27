package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.repository.AgencyRepository;
import peaksoft.service.AgencyService;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void saveAgency(Agency agency) {
        agencyRepository.save(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyRepository.findAll();
    }

    @Override
    public Agency getById(Long id) {
        try {
            return agencyRepository.findById(id).orElseThrow(()->new MyException("not found"));
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateAgencyById(Long id, Agency agency) throws MyException {
        Agency agency1 = agencyRepository.findById(id).orElseThrow(() -> new MyException("not found"));
        agency1.setName(agency.getName());
        agency1.setEmail(agency.getEmail());
        agency1.setCountry(agency.getCountry());
        agency1.setPhoneNumber(agency.getPhoneNumber());
        agency1.setImageLink(agency.getImageLink());
        agencyRepository.save(agency1);
    }

    @Override
    public void deleteById(Long id) {
        agencyRepository.deleteById(id);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return agencyRepository.searchHouse(word);
    }
}

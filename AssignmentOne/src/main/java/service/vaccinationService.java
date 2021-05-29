package service;

import java.util.Date;
import static java.util.Date.from;
import model.Vaccinations;
import model.Vaccines;
import repository.VaccineRepository;
import repository.vaccinationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vaccinationService {
    
    
    @Autowired
    private vaccinationRepository vaccineRepo;
    
        @Autowired
    private VaccineRepository vaccinesRepo;

    public Vaccinations findOne(Long id) {
        return vaccineRepo.findById(id).get();
    }

    public List<Vaccinations> findAll() {
        return (List<Vaccinations>) vaccineRepo.findAll();
    }

    public long count() {
        return vaccineRepo.count();
    }

    public void deleteByID(long vaccineID) {
        vaccineRepo.deleteById(vaccineID);
    }

    public void saveBook(Vaccinations v) {
        vaccineRepo.save(v);
    }  
    
        public List searchVaccine(String iso, Date f, Date t) {
        return (List<Vaccinations>) vaccineRepo.getVacThatContainTerm(iso, f, t);
    }  
        
    public List VacById(Long term1,Long term2,Long term3) {
        return (List<Vaccines>) vaccinesRepo.getVaccinesWhereID(term1,term2,term3);
    }  
}//end class


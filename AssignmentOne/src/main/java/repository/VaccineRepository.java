/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;
import java.util.List;
import model.Vaccines;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccines, Long> {
    // b FROM Book b WHERE b.title = :searchterm
        
    @Query("SELECT b FROM Vaccines b WHERE b.id =?1 OR b.id =?2 OR b.id =?3")
    public List<Vaccines> getVaccinesWhereID(Long term1, Long term2, Long term3);
}

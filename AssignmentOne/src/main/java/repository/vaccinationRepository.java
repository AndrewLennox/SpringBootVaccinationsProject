/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.Date;
import java.util.List;
import model.Vaccinations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Andrew
 */
@Repository
public interface vaccinationRepository extends CrudRepository<Vaccinations, Long> {
           
// String q = "SELECT a from Records a WHERE a.make = :make AND a.model = :model AND a.listPrice < :listPrice AND a.year = :year";
//From_date >= '2013-01-03' AND To_date   <= '2013-01-09'
    
    @Query("SELECT b FROM Vaccinations b WHERE b.iso_code LIKE ?1 AND b.v_date BETWEEN ?2 AND ?3")
    public List<Vaccinations> getVacThatContainTerm(String searchterm,Date f, Date t);
    
}


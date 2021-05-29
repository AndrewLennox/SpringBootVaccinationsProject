/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static java.util.Date.from;
import java.util.HashMap;
import model.Vaccinations;
import service.vaccinationService;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class vaccinationController {
    
   @Autowired
    private vaccinationService vaccinationService;

    @GetMapping("/vaccinations")
    public List<Vaccinations> getAll() {
        return vaccinationService.findAll();
    }
    
    @GetMapping("/viewAll")
    public ModelAndView viewAll(ModelAndView modelAndView) {
        //System.out.println("Size =" + vaccinationService.findAll().size());
        return new ModelAndView("/viewAll", "listVaccines", vaccinationService.findAll());
    }

    @GetMapping("search")
    public ModelAndView DisplaySearch() {

        return new ModelAndView("/Search", "searchVac", new Vaccinations());

    }
    
     //@PostMapping("/DoSearch")
//@RequestMapping(value = "/searchit", method=RequestMethod.POST )
    //@RequestParam String search, String searchDateFrom, String searchDateTo, @ModelAttribute Vaccinations v, Model model) throws ParseException
//    @PostMapping("/searchit")
//    public ModelAndView DoSearch(@RequestParam String vac, String dfrom, String dto, @ModelAttribute Vaccinations v, Model model) throws ParseException {
//        //System.out.println(vac);
//           //     System.out.println("date =" + from + to);
//        //System.out.println(vac);
//        //System.out.println("Size =" + vaccinationService.search(vac).size());
//
//
//        Date from=new SimpleDateFormat("yyyy-MM-dd").parse(dfrom);
//        Date to=new SimpleDateFormat("yyyy-MM-dd").parse(dto);
//  
//        return new ModelAndView("/SearchResult", "searchVac", vaccinationService.search(vac,from,to));
//        //bookService.search(a)
//    }
    @PostMapping("/DoSearch")
    public ModelAndView searchVaccination(@RequestParam String search, String searchDateFrom, String searchDateTo, @ModelAttribute Vaccinations v, Model model, BindingResult result) throws ParseException {
                        if (result.hasErrors()) {
            //return new ModelAndView("/Error");
            return new ModelAndView("/Error");
        }
        Date dateFrom=new SimpleDateFormat("yyyy-MM-dd").parse(searchDateFrom); 
        Date dateTo=new SimpleDateFormat("yyyy-MM-dd").parse(searchDateTo); 
        return new   ModelAndView("/SearchResult","searchVac", vaccinationService.searchVaccine(search, dateFrom, dateTo));  

    }
    
      @RequestMapping("/DrillDown/{id}")
    public ModelAndView drillDown(@PathVariable (name = "id") String id) {

        //id.split(id)
        Long vid =  Long.parseLong(id);
        
        Vaccinations v = vaccinationService.findOne(vid);
        
         // System.out.println("Vaccinations = "+v.getVaccines());
        String s = v.getVaccines();
        
        //System.out.println("Vaccines as a string = "+s);
        //String [] splitS = s.split(", ");
        List<Long> longNumbers = List.of(s.split(", ")).stream().map(num -> Long.parseLong(num)).collect(toList());

          //System.out.println(longNumbers.get(0));
          //System.out.println(longNumbers.get(1));
          //System.out.println(longNumbers.get(2));
        
         // System.out.println("List of strings = "+longNumbers);

          
        long nr = longNumbers.get(0);

          long nr2 = 0;
          if (longNumbers.size() < 2) {
              nr2 = longNumbers.get(0);
          }else{
                  nr2 = longNumbers.get(1);
                          }
          
          
          
          
          long nr3 = 0;
          if (longNumbers.size() < 3) {
              nr3 = longNumbers.get(0);
          }else{
                  nr3 = longNumbers.get(2);
                          }

//          String numbers = id;
//
//          List<Long> list = new ArrayList<Long>();
//          for (String s : numbers.split(",")) {
//              list.add(Long.parseLong(s));
//              System.out.println(s);
//          }

            Map<String, Object> model = new HashMap<String, Object>();
          model.put("searchVaccine", vaccinationService.VacById(nr, nr2, nr3));
          model.put("searchVac", vaccinationService.findOne(vid));

//          Long two = 0L;
//          Long three = 0L;
//
//          System.out.println(vaccinationService.VacById(one, two, three));
//          vaccinationService.VacById(one, two, three);

            //Vaccinations v = vaccinationService.findOne(vid);
            //return new ModelAndView("/DrillD", "searchVac",vaccinationService.findOne(vid));
            return new ModelAndView("/DrillD", "model",model);
    }
    


}

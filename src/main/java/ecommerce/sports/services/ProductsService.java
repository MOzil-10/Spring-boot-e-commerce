package ecommerce.sports.services;

import java.util.List;
import org.springframework.stereotype.Service;

import ecommerce.sports.model.SportProducts;
import ecommerce.sports.repository.SportsRepository;

@Service
public class ProductsService {

   private final SportsRepository sportsRepo;

    ProductsService(SportsRepository sportsRepo){
      
        this.sportsRepo = sportsRepo;
    }

    public List<SportProducts> getProducts(){

        return sportsRepo.findAll();
        
    }

    public SportProducts saveProducts(SportProducts products){

        return sportsRepo.save(products);
    }


    
    // public School fetchSchoolById(int id) {
    //     return schoolRepository.findById(id).orElse(null);
    // }

    
}

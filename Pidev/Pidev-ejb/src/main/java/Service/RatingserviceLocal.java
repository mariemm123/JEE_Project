package Service;

import javax.ejb.Local;

import entity.Rate;



@Local
public interface RatingserviceLocal {
 void addRate(Rate rate );
 
}

import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> allReviewed;

    public ThemePark (){
        this.allReviewed = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return allReviewed;
    }

    public void addToAllReviewed(IReviewed location) {
        allReviewed.add(location);
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisitCount();
        visitor.addAttraction(attraction);
    }

    public HashMap<String, Integer> getReviewDetails(){
        HashMap<String, Integer> reviewDetails = new HashMap<>();
        for (IReviewed review : allReviewed){
            reviewDetails.put(review.getName(), review.getRating());
        }
        return reviewDetails;
    }
}

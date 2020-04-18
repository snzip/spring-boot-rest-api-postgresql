import java.util.HashMap;
import java.util.Map;

public class Test  {

    public static void main(String[] args) {
        Map<Integer,Integer> productLicenseCount = new HashMap<>();

        productLicenseCount.merge(12, 1, Integer::sum);

        productLicenseCount.merge(12, 1, Integer::sum);

        productLicenseCount.merge(12, 1, Integer::sum);


        for(Integer productId : productLicenseCount.keySet()){
            System.out.println(productId  + " + " + productLicenseCount.get(productId));
        }
    }
    
}

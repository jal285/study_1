package 剑指offer;

/**
 * @author badpoone
 */
public class OfferNo65 {
    int add(int a, int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return  a;
        }
        return add(a^b,(a&b)<<1);
    }

}

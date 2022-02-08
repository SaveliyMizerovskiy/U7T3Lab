import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double total = 0.0;
        /* to be implemented in part (a) */
        for (MenuItem item: check) {
            total += item.getPrice();
        }
        return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        /* to be implemented in part (b) */
        for (MenuItem item: check) {
            if (item.isDailySpecial() || totalPrices() < 40){
                return false;
            }
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        /* to be implemented in part (c) */
        double orig = totalPrices();
        double total= totalPrices();
        int numCust = 0;
        if (couponApplies()){
            total = orig - orig * 0.25;
        }
        for (MenuItem item: check) {
            if (item.isEntree()){
                numCust ++;
            }
        }
        if (numCust > 5){
            total += orig * 0.2;
        }
        return total;
    }
}

/**
 * Created by Kappukappu on 9/7/17.
 */
public class Dog {
    String name;
    boolean size; //true for large, false for small
    boolean aggressive;
    int price;

    public Dog(String n, boolean s, boolean a){
        name = n;
        size = s;
        aggressive = a;
        if (size){
            price = 20;
        }
        else{
            price = 10;
        }
        if (aggressive){
            price += 45;
        }
    }

    public String getName(){
        return name;
    }

    public String getSize(){
        if (size){
            return "Large";
        }
        else{
            return "Small";
        }
    }

    public String getAggressive(){
        if (aggressive){
            return ("Yes");
        }
        else{
            return ("No");
        }
    }

    public int getPrice(){
        return price;
    }
}

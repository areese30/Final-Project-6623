/*Name:     Alexander Reese
Assignment: 4
Instructor: Yan Huang
Term: Fall  2020
IDE:        VSC*/

import java.util.*;

public class User{

    private String firstName;
    private String lastName;
    private int cardInfo;
    private String address;

    public User(){

        }

    public User(String newfirst, String newlast, int cardnumber, String shippinginfo) {
            firstName = newfirst;
            lastName = newlast;
            cardInfo = cardnumber;
            address = shippinginfo;
    }

    public String getFirstName(){ // get first name method

        return firstName;
    }

   public String getLastName(){ // get last name method

        return lastName;
    }

    public int getCardInfo(){ // get card method

        return cardInfo;
    }

    public String getAddress(){ // get address method

        return address;
    }
   
    public void setFirstName(String newfirst){ // set first name method

        firstName = newfirst;
    }

    public void setLastName(String newlast){ // set last name method

        lastName = newlast;
    }

    public void setCardInfo(int cardnumber){ // set card method

        cardInfo = cardnumber;
    }

    public void setAddress(String shippinginfo){ // set address method

        address = shippinginfo;
    }
}
package com.ecommerce.onlinebookshop.utility;

public class ConcreteValidChecker    {

     public static boolean isEmpty(String string) {
        return string.isEmpty();
    }

     public static boolean isNull(String string) {
        return string==null;
    }

    public static boolean  validString(String string){
         return !isEmpty(string) &&  !isNull(string);
    }

    public static boolean validId(Long id){
         return id>0;
    }

    public static boolean greaterZero(double amount){
         return amount > 0;
    }
 }

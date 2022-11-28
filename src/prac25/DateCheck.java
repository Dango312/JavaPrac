package prac25;

import java.util.ArrayList;

public class DateCheck {
    public static void main(String[] args){
        String regex = "(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d";
        ArrayList<String> dates = new ArrayList<>();
        dates.add("12/11/2007");
        dates.add("12/31/2007");
        dates.add("2003/12/10");

        boolean isValid;
        for(String date : dates){
            isValid = date.matches(regex);
            System.out.println(date + ":" + isValid);
        }
    }
}

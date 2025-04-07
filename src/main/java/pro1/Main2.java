package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(maxPersonsCount("KIKM",2024));
    }

    public static long maxPersonsCount(String department, int year)
    {
        String json = Api.getActionsByDepartment(department,year);
        ActionsList actions= new Gson().fromJson(json, ActionsList.class);

        //return -1; TODO 2.1: Vrať nejvyšší dosažený počet přihlášených studentů na jedné akci
        return actions.items
                .stream()
                .mapToLong(a -> a.personsCount)         //samotný max by nešel, předtím tu hodntu musím převést na číslo
                .max().getAsLong();                     //musím stanovit, že se jedná o číselné maximum


//        2. ZPŮSOB, JAK TO UDĚLAT
//        return actions.items.stream
//                .max(Comparator.comparing(a -> a.personsCount))
//                .get()

    }
}
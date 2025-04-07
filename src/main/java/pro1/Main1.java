package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(emptyActionsCount("KIKM",2024));
    }

    public static long emptyActionsCount(String department, int year)
    {
        String json = Api.getActionsByDepartment(department,year);              //actions by department - schedule (katedra, hodina)
        ActionsList actions= new Gson().fromJson(json, ActionsList.class);

        //return -1; TODO 1.1: Vrať počet akcí, které mají 0 přihlášených studentů:

        return actions.items
                .stream()                           //projde všechny položky (actions.items) - vytvoří proud těchto akcí
                .filter(a -> a.personsCount == 0 )    //filtrem vybere jen ty, které mají (personsCount == 0)
                .count();                           //spočítá jejich počet (po filtru)
    }
}
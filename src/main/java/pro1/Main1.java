package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(emptyActionsCount("KIKM", 2024));
    }

    public static long emptyActionsCount(String department, int year) {
        //získání JSON dat o rozvrhových akcích dané katedry a roku
        String json = Api.getActionsByDepartment(department, year);

        //parsování JSON řetězce do objektu typu ActionsList
        ActionsList actions = new Gson().fromJson(json, ActionsList.class);

        //filtrování akcí, kde je počet osob (obsazení) nula, a jejich spočítání
        return actions.items.stream()
                .filter(a -> a.personsCount == 0)
                .count();
    }
}

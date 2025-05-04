package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) {
        //výpis všech unikátních místností, ve kterých se konají akce dané katedry
        System.out.println(roomsSummary("KIKM",2024));
    }

    public static String roomsSummary(String department, int year) {
        //načtení dat a deserializace seznamu akcí
        String json = Api.getActionsByDepartment(department,year);
        ActionsList actions = new Gson().fromJson(json, ActionsList.class);

        //výběr unikátních místností, seřazení a spojení do řetězce odděleného čárkami
        String res = actions.items.stream()
                .map(i -> i.room)
                .filter(s -> s != null)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        return res;
    }
}

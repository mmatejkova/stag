package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import java.util.stream.Collectors;

public class Main5 {

    public static void main(String[] args) {
        System.out.println(roomsSummary("KIKM",2024));
    }

    public static String roomsSummary(String department, int year)
    {
        // TODO 5.1: Vrať výpis učeben, které katedra v daném roce využila (seřadit abecedně, oddělit čárkou) - abecedně to nebude  "J1, J3, J10, J11", ale "J1, J10, J11, J3"!!!
        String json = Api.getActionsByDepartment(department,year);                  //zkopírovala jsem z Main2 (tento a spodní řádek)
        ActionsList actions= new Gson().fromJson(json, ActionsList.class);

        String result = actions.items.stream()
                .map(a -> a.room)                                       //počet věcí v seznamu se nezmění, ale věci v seznamu se můžou změnit (mám data s místností, učitelem.. a já si z toho všeho vezmu pouze místnosti -> místo řetězce rozvrhových akcí mám řetězec místností, JEŠTĚ MUSÍM UPRAVIT ACTION (apiDataModel)
                .filter(r -> r != null)                                 //chci specifické místnosti
                .distinct()                                             //porovná data, zdali jsou stejné či ne - projde 600 místností a z nich udělá pouze ty unikátní (distinct) -> zredukovala jsem to
                .sorted()                                               //seřazení (jsou to Stringy, takže se to seřadí podle abecedy)
                .collect(Collectors.joining(","));              //spojí Stringy, joining()-pouze se jednoduše spojí, joining(",")-přidá mezi Stringy čárky
        return result;
    }
}
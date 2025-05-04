package pro1;

import java.util.ArrayList;
import com.google.gson.Gson;
import pro1.apiDataModel.ScopesList;

public class Main7 {
    public static String specializationDeadlines(int year) {
        String json =  Api.getSpecializations(2025);                       //získání JSON dat o přijímacích oborech z API

        ScopesList scopesList = new Gson().fromJson(json, ScopesList.class);    //deserializace JSON do objektu ScopesList pomocí knihovny Gson
        scopesList.uniqueScopes();                                              //odstranění duplicitních termínů (zůstávají jen jedinečné)
        scopesList.sortByDeadline();                                            //seřazení termínů podle data
        ArrayList<String> dates = scopesList.getScopesFormated();               //získání formátovaných dat (např."31.3.2025")

        String formated = String.join(",", dates);                     //spojení termínů do jednoho řetězce odděleného čárkami

        return formated;
    }
}

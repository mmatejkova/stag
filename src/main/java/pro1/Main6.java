package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

import java.util.Comparator;
import java.util.HashMap;

public class Main6 {
    public static void main(String[] args) {
        //výpis ID učitele, který má nejvíce studentů ve všech svých akcích
        System.out.println(idOfBestTeacher("KIKM",2024));
    }

    public static long idOfBestTeacher(String department, int year) {
        //načtení rozvrhových akcí a jejich deserializace
        String json = Api.getActionsByDepartment(department,year);
        ActionsList actions = new Gson().fromJson(json, ActionsList.class);

        //vytvoření mapy: učitelId → součet osob ve všech jeho akcích
        HashMap<Long,Integer> h = new HashMap<>();
        for(var a : actions.items) {
            Integer v = h.getOrDefault(a.teacherId, 0);
            h.put(a.teacherId, a.personsCount + v);
        }

        //nalezení učitele s nejvyšší hodnotou (nejvíc studentů)
        return h.entrySet().stream()
                .max(Comparator.comparing(p -> p.getValue()))
                .get().getKey();
    }
}

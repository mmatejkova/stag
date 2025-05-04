package pro1.apiDataModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ScopesList {
    //deserializovaný seznam oborů z JSON odpovědi
    @SerializedName("prijimaciObor")
    public List<Scope> items;

    public void sortByDeadline() {
        //seřazení oborů podle termínu přihlášky vzestupně
        this.items.sort(new Comparator<Scope>() {
            public int compare(Scope s1, Scope s2) {
                return s1.deadline.getDate().compareTo(s2.deadline.getDate());
            }
        });
    }

    private static ArrayList<String> uniqueStrings(ArrayList<String> dates) {
        //odstranění duplicitních dat
        return new ArrayList<>(new HashSet<>(dates));
    }

    public void uniqueScopes() {
        //odstranění duplicitních oborů na základě jejich termínu
        ArrayList<String> uniqueDates = uniqueStrings(this.getScopesFormated());

        this.items.clear(); //vyčištění původního seznamu

        //vytvoření nového seznamu oborů pouze s unikátními daty
        for (String date : uniqueDates) {
            Scope scope = new Scope();
            scope.deadline = new Deadline();
            scope.deadline.value = date;
            this.items.add(scope);
        }
    }

    public ArrayList<String> getScopesFormated() {
        //vrací seznam všech dat jako řetězců
        ArrayList<String> dates = new ArrayList<>();
        for (Scope scope : this.items) {
            dates.add(scope.deadline.value);
        }
        return dates;
    }
}

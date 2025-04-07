package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;

public class Main4 {

    public static void main(String[] args) {
         printShortestEmails("KIKM",5);
    }

    public static void printShortestEmails(String department, int count)
    {
        // TODO 4.1: Vypiš do konzole "count" nejkratších učitelských emailových adres
        String json = Api.getTeachersByDepartment(department);         //stáhnu si učitele jako u Main3
        TeachersList list = new Gson().fromJson(json, TeachersList.class);

        list.items.stream()
                .filter(t -> t.email != null)                           //některé položky neměly e-mail, ještě jsem musela profiltrovat
                .sorted(Comparator.comparing(t->t.email.length()))      //chci 5 nejkratších, u "min" nemůžu stanovit kolik jich chci
                .limit(5)
                .forEach(t -> System.out.println(t.email));


//        NEBO "toList" A PAK KLASICKÝ CYKLUS
//        List<Teacher> print = list.items.stream()
//                .sorted(Comparator.comparing(t->t.email.length()))
//                .limit(5).toList();
//        for(Teacher t : print)
//            System.out.println(t.email);
    }
}
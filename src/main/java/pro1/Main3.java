package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.Teacher;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(emailOfBestTeacher("KIKM",2024));
    }

    public static String emailOfBestTeacher(String department, int year)
    {
        // TODO 3.2:
        //  a) Stáhni seznam učitelů na katedře
        //  b) Stáhni seznam akcí na katedře
        //  c) Najdi učitele s nejvyšším "score" a vrať jeho e-mail

        String json1 = Api.getTeachersByDepartment(department);                         //a)
        String json2 = Api.getActionsByDepartment(department, year);                    //b)
        TeachersList teachersList = new Gson().fromJson(json1, TeachersList.class);     //a)
        ActionsList actionsList = new Gson().fromJson(json2, ActionsList.class);        //b)
        Teacher bestTeacher = teachersList                                              //c)
                .items.stream()
                .max(Comparator.comparing(t -> TeacherScore(t.id, actionsList)))
                .get();
        return bestTeacher.email;
    }

    public static long TeacherScore(long teacherId, ActionsList departmentSchedule)
    {
        //return 0; TODO 3.1: Doplň pomocnou metodu - součet všech přihlášených studentů na akcích daného učitele

        return departmentSchedule.items
                .stream()
                .filter(a -> a.teacherId == teacherId)      //zajímají mě pouze nějaké akce, budu filtrovat
                .mapToInt(a -> a.personsCount)              //převedu na číslo, až poté můžu počítat sumu
                .sum();
    }
}
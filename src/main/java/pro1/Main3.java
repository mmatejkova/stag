package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(emailOfBestTeacher("KIKM",2024));
    }

    public static String emailOfBestTeacher(String department, int year)
    {
        //získání seznamu učitelů a seznamu akcí z API
        String json = Api.getTeachersByDepartment(department);
        String json2 = Api.getActionsByDepartment(department,year);
        TeachersList teachersList = new Gson().fromJson(json,TeachersList.class);
        ActionsList actionsList = new Gson().fromJson(json2, ActionsList.class);

        //najde učitele, který má nejvyšší skóre podle počtu osob ve svých akcích
        return teachersList.items.stream()
                .max(Comparator.comparing(t -> TeacherScore(t.id, actionsList)))
                .get().email;
    }

    public static long TeacherScore(long teacherId, ActionsList departmentSchedule)
    {
        //spočítá celkový počet osob ve všech akcích daného učitele
        return departmentSchedule.items.stream()
                .filter(a -> a.teacherId == teacherId)
                .mapToLong(a -> a.personsCount)
                .sum();
    }
}

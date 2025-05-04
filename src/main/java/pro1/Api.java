package pro1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    //vytvoření HTTP klienta
    private static HttpClient client = HttpClient.newBuilder().build();

    //základní URL adresa STAG API
    private static String baseUrl = "https://stag-demo.uhk.cz/ws/services/rest2";

    public static String getTeachersByDepartment(String department) {
        //získání seznamu učitelů (podle katedry)
        return getFromUri(baseUrl + "/ucitel/getUciteleKatedry?outputFormat=JSON&katedra=" + department);
    }

    public static String getActionsByDepartment(String department, int year) {
        //získání rozvrhových akcí (podle katedry a roku)
        return getFromUri(baseUrl + "/rozvrhy/getRozvrhByKatedra?semestr=%25&outputFormat=JSON&katedra=" + department + "&rok=" + year);
    }

    public static String getSpecializations(int year) {
        //získání seznamu přijímacích oborů (podle roku)
        return getFromUri(baseUrl + "/prijimacky/getPrijimaciObory?outputFormat=JSON&rok=" + year + "&jenAktualni=false");
    }

    private static String getFromUri(String uri) {
        //odeslání HTTP GET požadavku na dané URI a vrácení těla odpovědi jako řetězce
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            return null;            //v případě chyby vrací null
        }
    }
}

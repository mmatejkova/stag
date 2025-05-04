package pro1.apiDataModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline {
    public String value;        //datum jako řetězec, např. "31.3.2025"

    public Date getDate() {
        //parsování (zpracování a rozbor) textového data do objektu Date pro snadnější porovnávání
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = format.parse(this.value);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

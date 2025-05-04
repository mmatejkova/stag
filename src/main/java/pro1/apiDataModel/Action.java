package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action {
    @SerializedName("obsazeni")
    public int personsCount;        //počet studentů zapsaných do akce

    @SerializedName("nazev")
    public String title;            //název akce

    @SerializedName("katedra")
    public String department;       //katedra

    @SerializedName("ucitIdno")
    public long teacherId;

    @SerializedName("mistnost")
    public String room;
}

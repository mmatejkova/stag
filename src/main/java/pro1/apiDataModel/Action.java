package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action         //aby nám deserializovala data z json do java
{
    @SerializedName("obsazeni")
    public int personsCount;
    @SerializedName("nazev")
    public String title;
    @SerializedName("katedra")
    public String department;
    @SerializedName("ucitIdno")
    public long teacherId;
    @SerializedName("mistnost")     //přidala jsem kvůli Main5
    public String room;
}

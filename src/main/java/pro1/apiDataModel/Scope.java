package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Scope {
    @SerializedName("eprDeadlinePrihlaska")         //specifikace termínu přihlášky pro daný obor, mapovaný na JSON klíč
    public Deadline deadline;
}

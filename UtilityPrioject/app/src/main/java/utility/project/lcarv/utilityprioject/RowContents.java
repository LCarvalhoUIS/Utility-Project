package utility.project.lcarv.utilityprioject;

import android.widget.CheckBox;
import android.widget.Chronometer;

/**
 * Created by Lucas on 9/30/2015.
 * The individual row for the checklist
 * Includes a chronometer and a checkbox (and the string within)
 */
public class RowContents {

    String itemToDo;
    double timePassed;
    Chronometer chrono;
    CheckBox check;


   public String getItemToDo()
    {
        return itemToDo;
    }
    public double getTimePassed()
    {
        return timePassed;
    }
    public Chronometer getChrono(){return chrono;}
    public CheckBox getCheck() {return check;}

    public void setItemToDo(String itemToDo)
    {
        this.itemToDo=itemToDo;
    }

    public void setTimePassed(double timePassed)
    {
        this.timePassed=timePassed;
    }
    public void setChrono(Chronometer chrono)
    {
        this.chrono=chrono;
    }
    public void setCheck(CheckBox check){this.check=check;}
}

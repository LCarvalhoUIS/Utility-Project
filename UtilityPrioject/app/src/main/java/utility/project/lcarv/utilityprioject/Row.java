package utility.project.lcarv.utilityprioject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Chronometer;

import java.util.ArrayList;

/*
 * Created by Lucas on 9/27/2015.
 *The adapter for the row and also the click listener for the rows
 */
public class Row extends BaseAdapter implements View.OnClickListener {

    private Activity theActivity;
    private ArrayList itemsChecklist;

    //Resources to pass the data on
    public Resources theResources;

    //A temporary value used later on
    RowContents tempValue=null;
    int count=0;

    public static LayoutInflater inflater=null;


//The constructor. Initiates the inflater in addition to getting the list, activity, and resources
    public Row(Activity theActivity, ArrayList itemsChecklist, Resources theResources)
    {
        this.theActivity=theActivity;
        this.itemsChecklist=itemsChecklist;
        this.theResources=theResources;
        inflater=(LayoutInflater)theActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @Override
    public int getCount() {

        if(itemsChecklist.size()<=0)
        {
            return 1;
        }
        return itemsChecklist.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Handles each individual row and what to display by using the position
    @Override
    public View getView(int position, View tv, ViewGroup parent) {
        View TheView=tv;
        RowHolder theHolder;

        if(tv!=null)
        { theHolder=(RowHolder)TheView.getTag();

        }
        else
        {
            TheView=inflater.inflate(R.layout.row,null);

            theHolder=new RowHolder();
            theHolder.chkBox=(CheckBox)TheView.findViewById(R.id.theCheckBox);



            theHolder.chrono=(Chronometer)TheView.findViewById(R.id.theChronometer);


            theHolder.chrono.start();
            if(tempValue!=null)
            {
                tempValue.setChrono(theHolder.chrono);
                tempValue.setCheck(theHolder.chkBox);
            }


            TheView.setTag(theHolder);


        }
        if(itemsChecklist.size()>0)
        {
            tempValue=null;
            tempValue=(RowContents)itemsChecklist.get(position);
            theHolder.chkBox.setText(tempValue.getItemToDo());

            theHolder.chrono.start();
            tempValue.setChrono(theHolder.chrono);
            tempValue.setCheck(theHolder.chkBox);
            theHolder.chkBox.setOnClickListener(new OnItemClickListener(position, tempValue.chrono,tempValue.check));
        }
        else
        {theHolder.chkBox.setText("N/A");







        }


        return TheView;
    }

    @Override
    public void onClick(View v) {

    }
    private class OnItemClickListener implements View.OnClickListener
    {
        private int mPosition;
        private Chronometer chrono;
        private CheckBox check;

        public OnItemClickListener(int position, Chronometer chrono, CheckBox check) {
            mPosition=position;
            this.chrono=chrono;
            this.check=check;
        }

        @Override
        public void onClick(View v) {





            chrono.stop();
            chrono.stop();

            SecondActivity act=(SecondActivity)theActivity;

            act.onItemClick(mPosition);


        }
    }
    //Private class to hold the two attributes temporarily
    private static class RowHolder{
        public CheckBox chkBox;
        public Chronometer chrono;
    }
}

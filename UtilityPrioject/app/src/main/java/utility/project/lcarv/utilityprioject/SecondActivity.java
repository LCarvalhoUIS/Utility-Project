package utility.project.lcarv.utilityprioject;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {



    public SecondActivity second=null;
    public ArrayList<RowContents> ListValues=new ArrayList<RowContents>();
    public String theTasks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        second=this;

        setListData();

        Resources res=getResources();
        ListView lv=(ListView)findViewById(R.id.theCheckboxes);
        Row theAdapter=new Row(second,ListValues,res);



        lv.setAdapter(theAdapter);





    }

    //Gets the input from the bundle and reads it, making it into a list
    private void setListData() {

        Bundle bundle=getIntent().getExtras();
        theTasks=bundle.getString("List");
        Scanner scanner= new Scanner(theTasks);



            while(scanner.hasNextLine()) {
                final RowContents theRow = new RowContents();
                theRow.setItemToDo(scanner.nextLine());
                ListValues.add(theRow);
            }








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(int mPosition) {

        RowContents tempContents=(RowContents)ListValues.get(mPosition);

        tempContents.getChrono().stop();




    }
}

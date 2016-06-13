package utility.project.lcarv.utilityprioject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
//Utility Project by Lucas Carvalho
public class MainActivity extends AppCompatActivity {

    private TextView inputSource;
   // private String input;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //For use once the button is pressed
        inputSource=(TextView)findViewById(R.id.input);



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

    //Go to the next activity and get the data
    public void btnPress(View view) {

        Intent intent=new Intent(this,SecondActivity.class);

        //Take the input and place it on the intent
        intent.putExtra("List",inputSource.getText().toString());

        startActivity(intent);

    }
}

package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {
    private TextView name_text_2;
    private TextView group_text_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        name_text_2 = (TextView)findViewById(R.id.name_text_2);
        group_text_2 = (TextView)findViewById(R.id.group_text_2);

        Intent intentFromParent = getIntent();


    }
}
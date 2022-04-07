package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    private Button navigate_to_activity;
    private Button display_info;
    private CheckBox name_checkbox;
    private CheckBox group_checkbox;
    private EditText name_text;
    private EditText group_text;
    private TextView view_info;

    private DisplayInfoButtonClickListener displayInfoButtonClickListener = new DisplayInfoButtonClickListener();
    private class DisplayInfoButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
//            Toast.makeText(this, "fgdhtsr", Toast.LENGTH_LONG).show();
            view_info.setText("");
            if(name_checkbox.isChecked() && !name_text.getText().toString().isEmpty()) {
                view_info.setText(name_text.getText().toString());
            }
            if(group_checkbox.isChecked() && !group_text.getText().toString().isEmpty()) {
                view_info.setText(view_info.getText().toString() + group_text.getText().toString());
            }
            if(view_info.toString().isEmpty()) {
                String err = "Error";
//                Toast.makeText(this, err, Toast.LENGTH_LONG).show();
            }
            else {
                view_info.setVisibility(View.VISIBLE);
            }
        }
    }

    private NavigateActivityButtonClickListener navigateActivityButtonClickListener = new NavigateActivityButtonClickListener();
    private class NavigateActivityButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(String.valueOf(PracticalTest01Var04SecondaryActivity.class));
            if(name_checkbox.isChecked() && !name_text.getText().toString().isEmpty()) {
                intent.putExtra("name", name_text.getText().toString());
            }
            if(group_checkbox.isChecked() && !group_text.getText().toString().isEmpty()) {
                intent.putExtra("group", group_text.getText().toString());
            }
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        navigate_to_activity = (Button)findViewById(R.id.navigate_btn);
        display_info = (Button)findViewById(R.id.diplay_btn) ;
        name_checkbox = (CheckBox)findViewById(R.id.name_check);
        group_checkbox = (CheckBox)findViewById(R.id.group_check);
        name_text = (EditText) findViewById(R.id.name_text);
        group_text = (EditText) findViewById(R.id.group_text);
        view_info = (TextView) findViewById(R.id.show_info_view);

        display_info.setOnClickListener(displayInfoButtonClickListener);
        navigate_to_activity.setOnClickListener(navigateActivityButtonClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (name_checkbox.isChecked()) {
            savedInstanceState.putString("name_text", name_text.getText().toString());
        }
        if (group_checkbox.isChecked()) {
            savedInstanceState.putString("group_text", group_text.getText().toString());
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("name_text")) {
            name_text = (EditText)findViewById(R.id.name_text);
            name_checkbox = (CheckBox)findViewById(R.id.name_check);
            name_text.setText(savedInstanceState.getString("name_text"));
            name_checkbox.setChecked(true);
        }
        if (savedInstanceState.containsKey("group_text")) {
            group_text = (EditText)findViewById(R.id.group_text);
            group_checkbox = (CheckBox)findViewById(R.id.group_check);
            group_text.setText(savedInstanceState.getString("group_text"));
            group_checkbox.setChecked(true);
        }
    }
}
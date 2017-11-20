package roberteriksson12.gmail.com.returninformationtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    private TextView textView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.diaryText);

        sharedPreferences  = getSharedPreferences("Test", 0);
        textView.setText(sharedPreferences.getString("diaryText", "Default value on first startup"));
    }

    public void onEditClick(View view){
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", textView.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){
            textView.setText(data.getStringExtra("answer"));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("diaryText", data.getStringExtra("answer"));
            editor.apply();
        }
    }
}

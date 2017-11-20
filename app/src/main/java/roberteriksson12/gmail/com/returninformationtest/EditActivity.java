package roberteriksson12.gmail.com.returninformationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        editText = (EditText)findViewById(R.id.editText);
        editText.setText(intent.getStringExtra("text"));
    }

    public void onDoneClick(View view){
        Intent intent = new Intent();
        intent.putExtra("answer", editText.getText().toString());
        setResult(1, intent);
        finish();
    }
}

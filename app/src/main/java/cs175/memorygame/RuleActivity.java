package cs175.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RuleActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        Button backToMain = (Button) findViewById(R.id.backBtn);
        backToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(RuleActivity.this, MainActivity.class);
                startActivity(goBack);
            }
        });
    }
}

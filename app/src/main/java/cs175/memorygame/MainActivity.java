package cs175.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playBtn = (Button) findViewById(R.id.playbtn);
        playBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(((MyApp)getApplication()).getBoolean() == true ) {
                    PopupMenu popup = new PopupMenu(MainActivity.this, findViewById(R.id.playbtn));
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getTitle().equals("Restart"))
                                ((MyApp)getApplication()).storeBoolean(false);

                            if (item.getTitle().equals("Resume")) {

                            }
                            Intent play = new Intent(MainActivity.this, PlayGround.class);
                            startActivity(play);
                            return true;
                        }
                    });

                    popup.show();
                } else {
                    Intent play = new Intent(MainActivity.this, PlayGround.class);
                    startActivity(play);
                }

            }
        });

        Button ruleBtn = (Button) findViewById(R.id.rulebtn);
        ruleBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent showRule = new Intent(MainActivity.this, RuleActivity.class);
                startActivity(showRule);
            }
        });

    }
}

package crayon.airtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewFlightActivity extends AppCompatActivity {

    Button bt_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_flight);
        bt_save = (Button)findViewById(R.id.button_save);

        getSupportActionBar().setTitle("New Flight");

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewFlightActivity.this, HomeActivity.class));
            }
        });
    }
}

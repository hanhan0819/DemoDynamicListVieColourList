package sg.edu.rp.c346.id21007466.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement,etIndexElement;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextText);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement=findViewById(R.id.editTextText2);
        alColours = new ArrayList<>();
        alColours.add("red");
        alColours.add("orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedColor = alColours.get(position);
                Toast.makeText(MainActivity.this, "Clicked color: " + clickedColor, Toast.LENGTH_SHORT).show();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
             //   alColours.add(newColor);
                int pos=Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos,newColor);
                aaColour.notifyDataSetChanged();
            }
        });
    }
}
package tomi.jsontehtava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button haeNappi;
    OmaAdapteri naytettavaLuokkaAdapteri;

    public static ArrayList<NaytettavaLuokka> lista;

    ListView listaView;

    public static JSONArray jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();


        naytettavaLuokkaAdapteri = new OmaAdapteri(MainActivity.this, R.layout.customleiska, lista);

        listaView = (ListView) findViewById(R.id.listaView);

        listaView.setAdapter(naytettavaLuokkaAdapteri);


        View.OnClickListener kuuntelija = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GetRawData getRawData = new GetRawData();
                getRawData.execute();
                if (lista != null) {
                    naytettavaLuokkaAdapteri.addAll(lista);
                }

            }
        };

        haeNappi = (Button) findViewById(R.id.button);

        haeNappi.setOnClickListener(kuuntelija);

    }

}

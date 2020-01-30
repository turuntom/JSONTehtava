package tomi.jsontehtava;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;

public class OmaAdapteri extends ArrayAdapter<NaytettavaLuokka> {

    private Context context;
    private LayoutInflater layoutInflater;

    private TextView otsikko;
    private TextView tekstiAlue;

    private ArrayList<NaytettavaLuokka> naytettavat;

    public OmaAdapteri(@NonNull Context context, int resource,@Nullable ArrayList<NaytettavaLuokka> naytettavat){
        super(context,resource);
        this.layoutInflater = LayoutInflater.from(context);
        this.naytettavat = naytettavat;
        this.context = context;
    }

    @Override
    public void addAll(@NonNull Collection<? extends NaytettavaLuokka> collection) {
        super.addAll(collection);
        naytettavat.addAll(collection);
        notifyDataSetChanged();
    }


    @Override
    public void add(@Nullable NaytettavaLuokka object) {
        super.add(object);
        naytettavat.add(object);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View view = layoutInflater.inflate(R.layout.customleiska, parent,false);
        otsikko = (TextView) view.findViewById(R.id.otsikko);
        tekstiAlue = (TextView) view.findViewById(R.id.tekstiAlue);



        final NaytettavaLuokka currentObject = naytettavat.get(position);

        final String tanId = ""+currentObject.getId();

        tekstiAlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, tanId, Toast.LENGTH_SHORT).show();
            }
        });

        otsikko.setText(currentObject.getTitle());
        tekstiAlue.setText(currentObject.getBody());

        ConstraintLayout cl = (ConstraintLayout) view;

        return  view;

    }

}

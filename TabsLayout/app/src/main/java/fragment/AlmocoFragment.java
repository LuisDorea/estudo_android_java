package fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.estudo.tabslayout.R;

public class AlmocoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_almoco, container, false);

        TextView tv = view.findViewById(R.id.text2);
        tv.setText("Feijão com arroz e um bife torrado!");

        return view;
    }

}
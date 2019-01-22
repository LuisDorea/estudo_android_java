package activity;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.TabsAdapter;
import br.com.estudo.tabslayout.R;
import fragment.AlmocoFragment;
import fragment.BebidasFragment;
import fragment.PetiscosFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.add(new BebidasFragment(), "Bebidas");
        adapter.add(new AlmocoFragment(), "Almoço");
        adapter.add(new PetiscosFragment(), "Petiscos");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

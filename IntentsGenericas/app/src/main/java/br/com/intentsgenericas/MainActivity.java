package br.com.intentsgenericas;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.acoes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Uri uri = null;
        Intent intencao = null;

        switch (position){

            //Abrindo uma url
            case 0:
                uri = Uri.parse("http://wwww.nglauber.com.br");
                intencao = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intencao);
                break;

            //Realizando uma chamada
            case 1:
                uri = Uri.parse("tel:993575307");
                intencao = new Intent(Intent.ACTION_DIAL, uri);
                dispararIntent(intencao);
                break;

                //Pesquisa uma posição no mapa
            case 2:
                uri = Uri.parse("geo:0,0?q=Rua+Amelia,Recife");
                intencao = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intencao);
                break;

                //exeecutar música do sdcard
            case 3:
                uri = Uri.parse("file:///mnt/sdcard/musica.mp3");
                intencao = new Intent().setAction(Intent.ACTION_VIEW).setDataAndType(uri,"audio/mp3");
                dispararIntent(intencao);
                break;

                //Abrindo o editor de sms
            case 4:
                uri = Uri.parse("sms:12345");
                intencao = new Intent(Intent.ACTION_VIEW,uri).putExtra("sms_body", "Corpo do SMS");
                dispararIntent(intencao);
                break;

                //Compartilhar
            case 5:
                intencao = new Intent().setAction(Intent.ACTION_SEND).putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent").setType("text/plain");
                dispararIntent(intencao);
                break;

                //Alarme
            case 6:
                ArrayList<Integer> dias = new ArrayList<Integer>();
                dias.add(Calendar.MONDAY);
                dias.add(Calendar.WEDNESDAY);
                dias.add(Calendar.FRIDAY);

                intencao = new Intent(AlarmClock.ACTION_SET_ALARM).putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android").putExtra(AlarmClock.EXTRA_HOUR, 19)
                        .putExtra(AlarmClock.EXTRA_MINUTES,0).putExtra(AlarmClock.EXTRA_SKIP_UI,true).putExtra(AlarmClock.EXTRA_DAYS, dias);
                dispararIntent(intencao);
                break;

                //Busca na WEB
            case 7:
                intencao = new Intent(Intent.ACTION_SEARCH).putExtra(SearchManager.QUERY, "Novatec");
                dispararIntent(intencao);
                break;

                //Configurações do aparelho
            case 8:
                intencao = new Intent(Settings.ACTION_SETTINGS);
                dispararIntent(intencao);
                break;

                //Ação customizada
            case 9:
                intencao = new Intent("dominando.android.ACAO_CUSTOMIZADA");
                dispararIntent(intencao);
                break;

                //Ação customizada 2
            case 10:
                uri = Uri.parse("produto://Notebook/Slim");
                intencao = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intencao);
                break;

            default:
                finish();
        }
    }

    private void dispararIntent(Intent intent){
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this,R.string.erro_intent,Toast.LENGTH_SHORT).show();
        }
    }
}

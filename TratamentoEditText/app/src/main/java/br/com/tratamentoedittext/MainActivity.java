package br.com.tratamentoedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private EditText mEdtNome;
    private EditText mEdtEmail;
    private EditText mEtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtNome = findViewById(R.id.edt_nome_id);
        mEdtEmail = findViewById(R.id.edt_email_id);
        mEtSenha = findViewById(R.id.edt_senha_id);

        mEtSenha.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (v == mEtSenha && EditorInfo.IME_ACTION_DONE == actionId){
            String nome = mEdtNome.getText().toString();
            String email = mEdtEmail.getText().toString();
            String senha = mEtSenha.getText().toString();

            boolean ok = true;

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                mEdtEmail.setError(getString(R.string.msg_erro_email));

                ok = false;
            }

            if (!senha.equals("123")){
                mEtSenha.setError(getString(R.string.msg_erro_senha));
                ok = false;
            }

            if (ok){
                Toast.makeText(this,
                        getString(R.string.msg_sucesso,nome,email),Toast.LENGTH_SHORT).show();
            }
            //ao comentar esse linha o teclado fecha ao final do envio do ultimo campo
            //return true;
        }
        return false;
    }
}

package br.com.victor.newcontactapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import br.com.victor.newcontactapp.model.Contact;
import br.com.victor.newcontactapp.view.EmailFragment;
import br.com.victor.newcontactapp.view.NomeFragment;
import br.com.victor.newcontactapp.view.TelefoneFragment;


public class MainActivity extends AppCompatActivity {

    int indice = 0;

    Contact contact = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button salvar = findViewById(R.id.salvar);
        salvar.setOnClickListener(v -> createContact(contact));

        Button forward = findViewById(R.id.forward);
        forward.setOnClickListener(v -> forwardFragment());

        Button backward = findViewById(R.id.backward);
        backward.setOnClickListener(v -> backwardFragment());
        navegarParaOutroFragmento(indice);
    }

    public void forwardFragment() {
        indice++;
        if (indice > 2) {
            indice = 2;
        }
        navegarParaOutroFragmento(indice);
    }

    public void backwardFragment() {
        indice--;
        if (indice < 0) {
            indice = 0;
        }
        navegarParaOutroFragmento(indice);
    }

    private void navegarParaOutroFragmento(int indice) {
        Fragment fragment = null;
        switch (indice) {
            case 0:
                fragment = new NomeFragment(contact);
                break;
            case 1:
                fragment = new TelefoneFragment(contact);
                break;
            case 2:
                fragment = new EmailFragment(contact);
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }

    public void createContact(Contact contact) {
        putDadosContato(contact);
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION)
                .putExtra(ContactsContract.Intents.Insert.NAME, contact.getNome().concat(" " + contact.getSobrenome()))
                .putExtra(ContactsContract.Intents.Insert.PHONE, contact.getTelefone())
                .putExtra(ContactsContract.Intents.Insert.EMAIL, contact.getEmail());
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        startActivity(intent);
    }

    private void putDadosContato(Contact contact) {
        EditText inputNome = findViewById(R.id.inputNome);
        EditText inputSobrenome = findViewById(R.id.inputSobrenome);
        EditText inputTelefone = findViewById(R.id.inputTelefone);
        EditText inputEmail = findViewById(R.id.inputEmail);

        if (inputNome != null) {
            contact.setNome(inputNome.getText().toString());
        }
        if (inputSobrenome != null) {
            contact.setSobrenome(inputSobrenome.getText().toString());
        }
        if (inputTelefone != null) {
            contact.setTelefone(inputTelefone.getText().toString());
        }
        if (inputEmail != null) {
            contact.setEmail(inputEmail.getText().toString());
        }
    }

}
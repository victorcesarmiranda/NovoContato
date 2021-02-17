package br.com.victor.newcontactapp.view;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import br.com.victor.newcontactapp.R;
import br.com.victor.newcontactapp.model.Contact;

public class NomeFragment extends Fragment {

    Contact contact;

    public NomeFragment(Contact contact) {
        super(R.layout.activity_nome);
        this.contact = contact;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText inputNome = getActivity().findViewById(R.id.inputNome);
        EditText inputSobrenome = getActivity().findViewById(R.id.inputSobrenome);
        inputNome.setText(contact.getNome());
        inputSobrenome.setText(contact.getSobrenome());
    }


    @Override
    public void onPause() {
        super.onPause();
        EditText inputNome = getActivity().findViewById(R.id.inputNome);
        EditText inputSobrenome = getActivity().findViewById(R.id.inputSobrenome);
        contact.setNome(inputNome.getText().toString());
        contact.setSobrenome(inputSobrenome.getText().toString());
    }
}

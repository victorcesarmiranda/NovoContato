package br.com.victor.newcontactapp.view;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import br.com.victor.newcontactapp.R;
import br.com.victor.newcontactapp.model.Contact;

public class TelefoneFragment extends Fragment {

    Contact contact;

    public TelefoneFragment(Contact contact) {
        super(R.layout.activity_telefone);
        this.contact = contact;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText inputTelefone = getActivity().findViewById(R.id.inputTelefone);
        inputTelefone.setText(contact.getTelefone());
    }

    @Override
    public void onPause() {
        super.onPause();
        EditText inputTelefone = getActivity().findViewById(R.id.inputTelefone);
        contact.setTelefone(inputTelefone.getText().toString());
    }

}

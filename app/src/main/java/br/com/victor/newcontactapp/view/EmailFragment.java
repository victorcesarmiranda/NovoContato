package br.com.victor.newcontactapp.view;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import br.com.victor.newcontactapp.R;
import br.com.victor.newcontactapp.model.Contact;

public class EmailFragment extends Fragment {

    Contact contact;

    public EmailFragment(Contact contact) {
        super(R.layout.activity_email);
        this.contact = contact;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText inputEmail = getActivity().findViewById(R.id.inputEmail);
        inputEmail.setText(contact.getEmail());
    }

    @Override
    public void onPause() {
        super.onPause();
        EditText inputEmail = getActivity().findViewById(R.id.inputEmail);
        contact.setEmail(inputEmail.getText().toString());
    }

}

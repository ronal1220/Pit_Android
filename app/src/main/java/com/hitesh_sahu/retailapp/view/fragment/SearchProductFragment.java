/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.fragment;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Medico;
import com.hitesh_sahu.retailapp.model.entities.Product;
import com.hitesh_sahu.retailapp.util.Constantes;
import com.hitesh_sahu.retailapp.util.JsonPlaceHolderApi;
import com.hitesh_sahu.retailapp.util.Utils;
import com.hitesh_sahu.retailapp.util.Utils.AnimationType;
import com.hitesh_sahu.retailapp.view.activities.ECartHomeActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchProductFragment extends Fragment {

    private static final int REQ_SCAN_RESULT = 200;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    //ArrayList<Product> searchProductList = new ArrayList<>();
    boolean searchInProgress = false;
    private TextView heading;
    private ImageButton btnSpeak;
    private EditText serchInput;
    private ListView serachListView;
    ArrayAdapter arrayAdapter;
    List<Medico> medicoList = new ArrayList<Medico>();

    /** The search adapter. */
    // private SearchListArrayAdapter searchAdapter;
    /**
     * The root view.
     */
    private View rootView;

    public static Fragment newInstance() {
        // TODO Auto-generated method stub
        return new SearchProductFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frag_search_product,
                container, false);

        btnSpeak = (ImageButton) rootView.findViewById(R.id.btnSpeak);

        heading = (TextView) rootView.findViewById(R.id.txtSpeech_heading);

        serchInput = (EditText) rootView.findViewById(R.id.edt_search_input);

        //serchInput.setSelected(true);

        serachListView = (ListView) rootView.findViewById(R.id.search_list_view);


        arrayAdapter = new ArrayAdapter(getActivity(),R.layout.itemlist,medicoList);
        serachListView.setAdapter(arrayAdapter);


        /** EVENTO ONCLICK */
        serachListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Medico medico = medicoList.get(position);
                String nombre = String.valueOf(serchInput.getText());

                //Toast.makeText(getActivity(), "Selected" + position, Toast.LENGTH_LONG).show();
                //cargaPostUsuarios(medico.getNomDoctor(), nombre);
            }
        });

        serchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence inputString, int arg1,
                                      int arg2, int arg3) {

                heading.setText("Buscando... "+ inputString.toString().toLowerCase());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {

                heading.setText("Buscar Medico");

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = String.valueOf(serchInput.getText());
                //cargaPostUsuarios(data);
            }
        });

        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    Utils.switchContent(R.id.frag_container,
                            Utils.HOME_FRAGMENT,
                            ((ECartHomeActivity) (getContext())),
                            AnimationType.SLIDE_DOWN);
                }
                return true;
            }
        });
        return rootView;
    }
    /*public void cargaPostUsuarios(String nombre){
        JsonPlaceHolderApi postService = Constantes.getConnection().create(JsonPlaceHolderApi.class);
        Call<List<Medico>> call = postService.getListaNombre(nombre);
        call.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                String mensaje = "";
                for(Medico x : response.body()) {
                    mensaje += x.getIdDoctor() +" : "+ x.getNomDoctor() + "\n" ;
                    mensaje += x.getEmailDoctor() + "\n\n" ;
                }
                mostrarMensaje( "Medico", mensaje);
            }
            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
                Toast.makeText(getContext(),"Error de conexión",Toast.LENGTH_LONG);
            }
        });
    }*/

    public void mostrarMensaje(String titulo, String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setMessage(msg);
        alertDialog.setTitle(titulo);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    /**
     * Showing google speech input dialog.
     */
    private void promptSpeechInput() {
        searchInProgress = true;
        //searchProductList.clear();

        heading.setText("Search Products");

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "What do you wish for");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity(),
                    "Voice search not supported by your device ",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input.
     *
     * @param requestCode the request code
     * @param resultCode  the result code
     * @param data        the data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        searchInProgress = false;

        if (resultCode == getActivity().RESULT_OK && null != data) {
            switch (requestCode) {
                case REQ_CODE_SPEECH_INPUT: {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    heading.setText("Total de resultado para " + result.get(0));

                    break;
                }

                case REQ_SCAN_RESULT:
                    //
                    // String contents = data.getStringExtra("SCAN_RESULT");
                    // String format = data.getStringExtra("SCAN_RESULT_FORMAT");
                    // Toast.makeText(getActivity(), "Scan Success", 1000).show();
                    break;

            }

        }

    }

}

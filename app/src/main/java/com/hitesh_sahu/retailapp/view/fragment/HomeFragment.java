/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Medico;
import com.hitesh_sahu.retailapp.util.Constantes;
import com.hitesh_sahu.retailapp.util.JsonPlaceHolderApi;
import com.hitesh_sahu.retailapp.util.Utils;
import com.hitesh_sahu.retailapp.util.Utils.AnimationType;
import com.hitesh_sahu.retailapp.view.activities.DetalleActivity;
import com.hitesh_sahu.retailapp.view.activities.ECartHomeActivity;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    int mutedColor = R.attr.colorPrimary;
    private CollapsingToolbarLayout collapsingToolbar;
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    ArrayList<String> item = new ArrayList<String>();
    List<Medico> medicos = new ArrayList<Medico>();
    /**
     * The double back to exit pressed once.
     */
    private boolean doubleBackToExitPressedOnce;
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };


    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_product_category, container, false);

        arrayAdapter = new ArrayAdapter(getActivity(),R.layout.itemlist,item);
        listView = (ListView) view.findViewById(R.id.lista);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Medico obj = medicos.get(i);
                String titulo = obj.getNomDoctor();

                String mensaje = "codigo : " + obj.getIdDoctor() + "\n";
                 mensaje += "codigo CMP : " + obj.getCmpDoctor() + "\n";
                 mensaje += "email : " + obj.getEmailDoctor() + "\n";
                mensaje += "Contacto : " + obj.getTelDoctor() + "\n";
                 mostrarMensaje(obj.getNomDoctor(), mensaje);
            }
        });
        cargaDatosUsuarios();

        view.findViewById(R.id.search_item).setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.switchFragmentWithAnimation(R.id.frag_container,
                                new SearchProductFragment(),
                                ((ECartHomeActivity) getActivity()), null,
                                AnimationType.SLIDE_UP);
                    }
                });

        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.anim_toolbar);
        ((ECartHomeActivity) getActivity()).setSupportActionBar(toolbar);
        ((ECartHomeActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ECartHomeActivity) getActivity()).getmDrawerLayout()
                        .openDrawer(GravityCompat.START);
            }
        });

        collapsingToolbar = (CollapsingToolbarLayout) view
                .findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setTitle("Medicos");

        ImageView header = (ImageView) view.findViewById(R.id.header);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.header);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {

                mutedColor = palette.getMutedColor(R.color.primary_500);
                collapsingToolbar.setContentScrimColor(mutedColor);
                collapsingToolbar.setStatusBarScrimColor(R.color.black_trans80);
            }
        });

        //Bundle bundle = getActivity().gete
        //String nombre = bundle.getString("nombre");
        Log.e("TAG->","HOME FRAGMENT");

        /*  EMPIEZA EL RECYCLER */

        /*recyclerView = (RecyclerView) view.findViewById(R.id.scrollableview);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        new ProductCategoryLoaderTask(recyclerView, getActivity()).execute();*/

//
//		if (simpleRecyclerAdapter == null) {
//			simpleRecyclerAdapter = new CategoryListAdapter(getActivity());
//			recyclerView.setAdapter(simpleRecyclerAdapter);
//
//			simpleRecyclerAdapter
//					.SetOnItemClickListener(new OnItemClickListener() {
//
//						@Override
//						public void onItemClick(View view, int position) {
//
//							if (position == 0) {
//								CenterRepository.getCenterRepository()
//										.getAllElectronics();
//							} else if (position == 1) {
//								CenterRepository.getCenterRepository()
//										.getAllFurnitures();
//							}
//							Utils.switchFragmentWithAnimation(
//									R.id.frag_container,
//									new ProductOverviewFragment(),
//									((ECartHomeActivity) getActivity()), null,
//									AnimationType.SLIDE_LEFT);
//
//						}
//					});
//		}

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    if (doubleBackToExitPressedOnce) {
                        // super.onBackPressed();

                        if (mHandler != null) {
                            mHandler.removeCallbacks(mRunnable);
                        }
                        getActivity().finish();

                        return true;
                    }                    doubleBackToExitPressedOnce = true;


                    Toast.makeText(getActivity(),
                            "Please click BACK again to exit",
                            Toast.LENGTH_SHORT).show();

                    mHandler.postDelayed(mRunnable, 2000);

                }
                return true;
            }
        });

        return view;

    }

    public void mostrarMensaje(final String titulo, String msg){
        final String da = titulo;
        Log.e("ver", da);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setMessage(msg);
        alertDialog.setTitle(titulo);
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("Mas Info", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getActivity(), DetalleActivity.class);
                intent.putExtra("nombre",da);
                startActivity(intent);
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }
    public void cargaDatosUsuarios(){
        JsonPlaceHolderApi postService = Constantes.getConnection().create(JsonPlaceHolderApi.class);
        Call<List<Medico>> call = postService.getLista();
        call.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                medicos = response.body();
                for(Medico x : medicos) {
                    item.add( x.getNomDoctor());
                }
                arrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
            }
        });
    }
}

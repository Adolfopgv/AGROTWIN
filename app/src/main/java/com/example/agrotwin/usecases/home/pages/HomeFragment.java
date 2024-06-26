package com.example.agrotwin.usecases.home.pages;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.agrotwin.usecases.home.pages.homecardadapter.DataClass;
import com.example.agrotwin.usecases.home.pages.homecardadapter.MyAdapter;
import com.example.agrotwin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragmento que muestra la página de inicio de la aplicación.
 * Muestra una lista de elementos y permite buscar entre ellos.
 * @author Adolfo Pérez-Gascón Valls
 * @author David Pimentel
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<DataClass> dataList;
    private MyAdapter adapter;
    private DataClass androidData;
    private SearchView searchView;

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        searchView = view.findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            androidData = new DataClass("Camera");
            dataList.add(androidData);
        }

        adapter = new MyAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    /**
     * Método para buscar elementos en la lista.
     *
     * @param text El texto a buscar en los elementos de la lista.
     */
    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(getContext(), "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}
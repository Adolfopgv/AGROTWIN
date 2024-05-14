package com.example.agrotwin.usecases.home.pages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.agrotwin.model.domain.FontSizeManager;
import com.example.agrotwin.R;

public class FavoritesFragment extends Fragment {

    public FavoritesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        TextSizes(view);

        return view;
    }

    private static void TextSizes(View view) {
        TextView[] texts = { view.findViewById(R.id.textFavoriteFragment) };

        for (TextView text : texts) {
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, FontSizeManager.getInstance().getTextSize());
        }
    }
}
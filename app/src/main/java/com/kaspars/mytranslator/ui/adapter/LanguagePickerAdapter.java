package com.kaspars.mytranslator.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kaspars.mytranslator.Languages;
import com.kaspars.mytranslator.R;
import com.kaspars.mytranslator.models.Language;

import java.util.List;



public class LanguagePickerAdapter extends BaseAdapter {
    public static final String DROPDOWN = "dropdown";
    public static final String NON_DROPDOWN = "non_dropdown";

    private final List<Language> mLanguages;

    public LanguagePickerAdapter() {
        mLanguages = Languages.getInstance().getLanguages();
    }

    @Override
    public int getCount() {
        return mLanguages.size();
    }

    @Override
    public Object getItem(int position) {
        return mLanguages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        if (view == null || !view.getTag().toString().equals(DROPDOWN)) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_language_dropdown, parent, false);
            view.setTag(DROPDOWN);
        }

        TextView textView = (TextView) view.findViewById(R.id.language);
        textView.setText(getTitle(position));

        return view;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null || !view.getTag().toString().equals(NON_DROPDOWN)) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_language, parent, false);
            view.setTag(NON_DROPDOWN);
        }

        TextView textView = (TextView) view.findViewById(R.id.language);
        textView.setText(getTitle(position));

        return view;
    }

    private String getTitle(int position) {
        return mLanguages.get(position).getName();
    }
}
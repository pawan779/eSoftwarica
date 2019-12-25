package com.pawan.esoftwarica.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pawan.esoftwarica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);
        WebView webView=(WebView) view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://softwarica.edu.np/");

        return view;

    }

}

package com.example.task91p;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task91p.R;
import com.google.android.gms.maps.SupportMapFragment;

public class HomePageFragment extends Fragment {

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    //actions to take after the view has been inflated
    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Button newAdvertButton = view.findViewById(R.id.newAdvertButton);
        Button itemsDisplayButton = view.findViewById(R.id.showAllButton);
        Button showMapButton = view.findViewById(R.id.showMapButton);

        newAdvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new NewAdvertFragment();
                selectFragment(fragment);
            }
        });


        itemsDisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ItemsDisplayFragment();
                selectFragment(fragment);
            }
        });

        showMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               MapsFragment fragment = new MapsFragment();
               fragment.onCreate(savedInstanceState);
            }
        });
    }

    public void selectFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainActivityFragment, fragment) .addToBackStack(null).commit();
    }
}
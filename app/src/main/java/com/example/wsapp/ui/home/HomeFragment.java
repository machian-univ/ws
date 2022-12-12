package com.example.wsapp.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wsapp.LoginResponse;
import com.example.wsapp.R;
import com.example.wsapp.RecyclerViewAdapter;
import com.example.wsapp.databinding.FragmentHomeBinding;

import java.util.Base64;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    String list[] = {"a", "b", "c"};

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


//        Navigation.findNavController(v).navigate(R.id.name);

        recyclerView = root.findViewById(R.id.feelings_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(list));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public Bitmap getBitmap(String img) {
        byte[] array = Base64.getDecoder().decode(img);
        return BitmapFactory.decodeByteArray(array, 0, array.length);
    }
}
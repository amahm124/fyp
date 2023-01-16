package com.example.healthapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthapp.Adapter.HealthScrollAdapter;
import com.example.healthapp.Adapter.SliderAdapter;
import com.example.healthapp.Model.HealthScroll;
import com.example.healthapp.Model.SliderData;
import com.example.healthapp.R;
import com.example.healthapp.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();


        SliderView sliderView = binding.slider;


        sliderDataArrayList.add(new SliderData(R.drawable.image1));
        sliderDataArrayList.add(new SliderData(R.drawable.image2));
        sliderDataArrayList.add(new SliderData(R.drawable.image3));


        SliderAdapter adapter = new SliderAdapter(getActivity(), sliderDataArrayList);


        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);


        sliderView.setSliderAdapter(adapter);


        sliderView.setScrollTimeInSec(3);


        sliderView.setAutoCycle(true);


        sliderView.startAutoCycle();

//
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
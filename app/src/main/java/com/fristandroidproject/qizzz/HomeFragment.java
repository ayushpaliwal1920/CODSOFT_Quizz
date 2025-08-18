package com.fristandroidproject.qizzz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fristandroidproject.qizzz.adapterclass.HomeAdapter;
import com.fristandroidproject.qizzz.databinding.FragmentHomeScreenBinding;
import com.fristandroidproject.qizzz.modelclass.HomeModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

FragmentHomeScreenBinding binding;
ArrayList<HomeModel> list = new ArrayList<>();
HomeAdapter homeAdapter;
    public HomeFragment() {

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(getLayoutInflater());

        loadData();
        return binding.getRoot();
    }

    private void loadData() {
        binding.rcvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("Science","Explore the natural world and its phenomena."));
        list.add(new HomeModel("Mathematics","Sharpen problem-solving and logical thinking skills."));
        list.add(new HomeModel("Technology & Computers","Dive into the digital age and innovations."));
        list.add(new HomeModel("General Knowledge","Test your awareness of the world around you."));
        list.add(new HomeModel("Literature & Arts","Dive into creativity, culture, and imagination."));
        list.add(new HomeModel("Current Affairs & Politics","Stay updated with today’s world."));
        list.add(new HomeModel("Mythology & Religion","Knowledge of beliefs and traditions."));
        list.add(new HomeModel("Health & Medicine","Explore the science of life and wellness."));
        list.add(new HomeModel("Logic & Puzzles","Boost critical thinking and problem-solving skills."));
        list.add(new HomeModel("Entertainment & Pop Culture","Fun category for casual learners"));

        homeAdapter = new HomeAdapter(getContext(),list);
        binding.rcvHome.setAdapter(homeAdapter);
    }
}
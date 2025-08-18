package com.fristandroidproject.qizzz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.fristandroidproject.qizzz.databinding.FragmentResultBinding;


public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    int correct;
    int totalQues;
    QuizFragment quizFragment;
    String category;
    String titleSub;

    public ResultFragment() {
    }


    public ResultFragment(int correct ,int totalQues,String category,String titleSub) {
        this.totalQues = totalQues;
        this. correct = correct;
        this.category = category;
        this.titleSub = titleSub;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding = FragmentResultBinding.inflate(getLayoutInflater());
       String correctScore = String.valueOf(correct);
       String totalScore = String.valueOf(totalQues);
       String wrongScore = String.valueOf(totalQues-correct);
       binding.correct.setText(correctScore +" Correct");
       binding.incorrect.setText(wrongScore +" Wrong");
       binding.scoreTV.setText("Well Done ! You got the "+correctScore+" out of "+totalScore);
        binding.btnExplore.setOnClickListener(v->{
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapContainer,new HomeFragment()).addToBackStack(null).commit();
        });

        binding.btnReplay.setOnClickListener(v-> {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapContainer, new QuizFragment(category,titleSub)).addToBackStack(null).commit();
        });


            return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Important for ViewBinding in Fragments
    }
}
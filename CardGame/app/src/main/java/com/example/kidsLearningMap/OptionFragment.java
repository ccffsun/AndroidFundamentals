package com.example.kidsLearningMap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kidsLearningMap.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OptionFragment extends Fragment {

    public OptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button_shape = view.findViewById(R.id.button_shape);
        Button button_color = view.findViewById(R.id.button_color);
        Button button_alph = view.findViewById(R.id.button_alph);
        Button button_number = view.findViewById(R.id.button_number);
        Button button_animal = view.findViewById(R.id.button_animal);

        button_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(getActivity(),v.getId());
                controller.navigate(R.id.action_optionFragment_to_exampleShapeFragment);
            }
        });

        button_alph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(getActivity(),v.getId());
                controller.navigate(R.id.action_optionFragment_to_exampleAlphabetFragment3);
            }
        });


        button_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(getActivity(),v.getId());
                controller.navigate(R.id.action_optionFragment_to_exampleAnimalFragment);
            }
        });

        button_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(getActivity(),v.getId());
                controller.navigate(R.id.action_optionFragment_to_exampleColorFragment);
            }
        });

        button_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(getActivity(),v.getId());
                controller.navigate(R.id.action_optionFragment_to_exampleNumberFragment);
            }
        });
    }
}

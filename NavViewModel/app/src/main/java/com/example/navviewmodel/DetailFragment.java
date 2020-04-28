package com.example.navviewmodel;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navviewmodel.databinding.FragmentDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel viewModel;
        viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        FragmentDetailBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_detailFragment_to_masterFragment);
            }
        });
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false);
        return binding.getRoot();
    }
}

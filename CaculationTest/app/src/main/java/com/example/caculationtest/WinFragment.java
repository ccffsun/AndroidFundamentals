package com.example.caculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.caculationtest.databinding.FragmentQuestionBinding;
import com.example.caculationtest.databinding.FragmentWinBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class WinFragment extends Fragment {

    public WinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_win, container, false);
        final MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),requireActivity())).get(MyViewModel.class);
        final FragmentWinBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_win,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_winFragment_to_titleFragment);
            }
        });


      return binding.getRoot();
    }
}

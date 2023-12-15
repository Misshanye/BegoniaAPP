package com.example.zkyapp.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.zkyapp.BlankFragment1;
import com.example.zkyapp.BlankFragment2;
import com.example.zkyapp.BlankFragment3;
import com.example.zkyapp.R;
import com.example.zkyapp.databinding.FragmentHomeBinding;
import com.example.zkyapp.databinding.FragmentQuitBinding;
import com.example.zkyapp.ui.quit.QuitViewModel;
public class HomePage extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel quitViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RadioGroup radioGroup=root.findViewById(R.id.radioGroup);
        RadioGroupListener lis=new RadioGroupListener();
        radioGroup.setOnCheckedChangeListener(lis);
        return root;
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId==R.id.home_message)
                entry_Fragment(new BlankFragment1());
            else if(checkedId==R.id.home_contact)
                entry_Fragment(new BlankFragment2());
            else if(checkedId==R.id.home_Else)
                entry_Fragment(new BlankFragment3());
        }
    }

    private void entry_Fragment(Fragment fragment)
    {
        FragmentManager fm= getActivity().getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.homeFragment,fragment);
        ft.addToBackStack(null);//不希望出现堆栈
        ft.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
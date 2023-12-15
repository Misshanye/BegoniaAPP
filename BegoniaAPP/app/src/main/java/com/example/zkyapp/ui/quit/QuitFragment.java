package com.example.zkyapp.ui.quit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.zkyapp.R;
import com.example.zkyapp.databinding.FragmentQuitBinding;

public class QuitFragment extends Fragment {
        private FragmentQuitBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                     ViewGroup container, Bundle savedInstanceState) {
        QuitViewModel quitViewModel =
                new ViewModelProvider(this).get(QuitViewModel.class);

        binding = FragmentQuitBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textQuit;
        quitViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

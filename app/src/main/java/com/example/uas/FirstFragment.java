package com.example.uas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

	private Button firstFragmentButton;
	private Spinner spinnerCategory;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_first, container, false);

		//views
		firstFragmentButton = view.findViewById(R.id.firstFragment);
		spinnerCategory = view.findViewById(R.id.spinnerCategory);

		// spinner
		String[] categories = {"Student", "Worker", "etc.."};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				requireContext(),
				android.R.layout.simple_spinner_item,
				categories
		);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCategory.setAdapter(adapter);

		// Button
		firstFragmentButton.setOnClickListener(v -> {
			String selected = spinnerCategory.getSelectedItem().toString();
			Toast.makeText(getContext(), "Selected: " + selected, Toast.LENGTH_SHORT).show();
		});

		return view;
	}
}

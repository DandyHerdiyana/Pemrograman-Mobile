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

import com.google.firebase.analytics.FirebaseAnalytics;

public class FirstFragment extends Fragment {

	private Button firstFragmentButton;
	private Spinner spinnerCategory;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_first, container, false);

		// Views
		firstFragmentButton = view.findViewById(R.id.firstFragment);
		spinnerCategory = view.findViewById(R.id.spinnerCategory);

		// Spinner setup
		String[] categories = {"Student", "Worker", "etc.."};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				requireContext(),
				android.R.layout.simple_spinner_item,
				categories
		);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCategory.setAdapter(adapter);

		// Firebase Analytics instance
		FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());

		// Log screen view
		Bundle screenBundle = new Bundle();
		screenBundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "FirstFragment");
		screenBundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "FirstFragment");
		firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, screenBundle);

		// Submit button
		firstFragmentButton.setOnClickListener(v -> {
			String selected = spinnerCategory.getSelectedItem().toString();
			Toast.makeText(getContext(), "Selected: " + selected, Toast.LENGTH_SHORT).show();

			// Log to Firebase
			Bundle bundle = new Bundle();
			bundle.putString("category_selected", selected);
			firebaseAnalytics.logEvent("submit_button_clicked", bundle);
		});

		// Home button
		Button homeBtn = view.findViewById(R.id.home);
		homeBtn.setOnClickListener(v -> {
			if (getActivity() != null) {
				getActivity().findViewById(R.id.mainContent).setVisibility(View.VISIBLE);

				getParentFragmentManager()
						.beginTransaction()
						.remove(this)
						.commit();
			}
		});

		return view;
	}
}

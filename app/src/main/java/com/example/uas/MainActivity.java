package com.example.uas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	Button firstFragment, secondFragment;
	LinearLayout mainContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		firstFragment = findViewById(R.id.firstFragment);
		secondFragment = findViewById(R.id.secondFragment);
		mainContent = findViewById(R.id.mainContent); // this is the wrapper

		firstFragment.setOnClickListener(view -> {
			loadFragment(new FirstFragment());
		});

		secondFragment.setOnClickListener(view -> {
			loadFragment(new SecondFragment());
		});
	}

	private void loadFragment(Fragment fragment) {
		// Hide main layout
		if (mainContent != null) {
			mainContent.setVisibility(View.GONE);
		}

		// Show fragment
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.frameLayout, fragment);
		transaction.commit();
	}
}

package com.example.uas;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

	MaterialCardView cardFirst, cardSecond;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Link the cards from layout
		cardFirst = findViewById(R.id.cardFirst);
		cardSecond = findViewById(R.id.cardSecond);

		// Set listener for the first fragment
		cardFirst.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loadFragment(new FirstFragment());
			}
		});

		// Set listener for the second fragment
		cardSecond.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loadFragment(new SecondFragment());
			}
		});
	}

	// Function to load fragments into the frame layout
	private void loadFragment(Fragment fragment) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.frameLayout, fragment);
		transaction.commit();
	}
}

package com.example.uas;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uas.FirstFragment;
import com.example.uas.SecondFragment;

public class MainActivity extends AppCompatActivity {

	Button firstFragment, secondFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		firstFragment = (Button) findViewById(R.id.firstFragment);
		secondFragment = (Button) findViewById(R.id.secondFragment);

		firstFragment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loadFragment(new FirstFragment());
			}
		});

		secondFragment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loadFragment(new SecondFragment());
			}
		});
	}

	private void loadFragment(Fragment fragment) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		fragmentTransaction.replace(R.id.frameLayout, fragment);
		fragmentTransaction.commit();
	}
}
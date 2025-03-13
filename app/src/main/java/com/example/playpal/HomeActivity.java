package com.example.playpal;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * This activity is a base activity for the four main app screens:
 * Posts feed, Map, Schedule, Profile. This class manages transition
 * between the screens, which are displayed using fragments. The transition
 * is done by clicking on the respective icons in the bottom navigation bar.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        PostsScreenFragment postsScreenFragment = new PostsScreenFragment();
        ScheduleScreenFragment scheduleScreenFragment = new ScheduleScreenFragment();
        MapScreenFragment mapScreenFragment = new MapScreenFragment();
        ProfileScreenFragment profileScreenFragment = new ProfileScreenFragment();

        setCurrentFragment(postsScreenFragment);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            System.out.println(">>>debug: " + item);

            // Using strings is probably not the best idea, But I needed some solution quick...
            switch (item.toString()) {
                case "Profile Icon":
                    setCurrentFragment(profileScreenFragment);
                case "Schedule Icon":
                    setCurrentFragment(scheduleScreenFragment);
                case "Post Icon":
                    setCurrentFragment(postsScreenFragment);
                case "Map Icon":
                    setCurrentFragment(mapScreenFragment);
            }
            return true;
        });
    }

    /**
     * Replaces fragments in this activity.
     * @param fragment to transition to
     */
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }
}
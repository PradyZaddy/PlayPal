package com.example.playpal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity
{
    PostScreenFragment postFragment;

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

        PostScreenFragment postsScreenFragment = new PostScreenFragment();
        ScheduleScreenFragment scheduleScreenFragment = new ScheduleScreenFragment();
        MapScreenFragment mapScreenFragment = new MapScreenFragment();
        ProfileScreenFragment profileScreenFragment = new ProfileScreenFragment();

        MakePostFragment makePostFragment = new MakePostFragment();

        setCurrentFragment(postsScreenFragment);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            System.out.println(">>>debug: " + item);

            // Using strings is probably not the best idea, But I needed some solution quick...
            switch (item.toString()) {
                case "Profile Icon":
                    /// FOR TESTING - the original line (commented out) needs to be used instead
                    //setCurrentFragment(profileScreenFragment);
                    setCurrentFragment(makePostFragment);
                    break;
                case "Schedule Icon":
                    setCurrentFragment(scheduleScreenFragment);
                    break;
                case "Post Icon":
                    setCurrentFragment(postsScreenFragment);
                    break;
                case "Map Icon":
                    setCurrentFragment(mapScreenFragment);
                    break;
            }
            return true;
        });
    }

    /**
     * Replaces fragments in this activity.
     * @param fragment to transition to
     */
    private void setCurrentFragment(Fragment fragment) {
        System.out.println(">>>setting " + fragment + " in home activity");
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }
}
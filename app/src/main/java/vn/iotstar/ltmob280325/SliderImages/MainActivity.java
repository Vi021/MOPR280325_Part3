package vn.iotstar.ltmob280325.SliderImages;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.SliderImages.ViewFlipper.VFFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabL_frags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabL_frags = findViewById(R.id.tabL_frags);
        tabL_frags.addTab(tabL_frags.newTab().setText("VF"));       //ViewFlipper
        tabL_frags.addTab(tabL_frags.newTab().setText("CI&VP"));    //CircleIndicator&ViewPager
        tabL_frags.addTab(tabL_frags.newTab().setText("CI3&VP2"));  //CircleIndicator3&ViewPager2
        tabL_frags.addTab(tabL_frags.newTab().setText("SV"));       //SliderView
        tabL_frags.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment selectedFragment = null;

                int item = tab.getPosition();
                if (item == 0) {
                    selectedFragment = new VFFragment();
                } else if (item == 1) {
                    //selectedFragment = new CIVPFragment();
                } else if (item == 2) {
                    //selectedFragment = new CI3VP2Fragment();
                } else if (item == 3) {
                    //selectedFragment = new SVFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmL_container, selectedFragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frmL_container, new VFFragment()).commit();
        }
    }
}
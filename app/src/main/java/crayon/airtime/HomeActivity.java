package crayon.airtime;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import crayon.airtime.cardsviewpager.CardFragmentPagerAdapter;
import crayon.airtime.cardsviewpager.CardItem;
import crayon.airtime.cardsviewpager.CardPagerAdapter;
import crayon.airtime.cardsviewpager.ShadowTransformer;
import crayon.airtime.fragments.ChatsFragment;
import crayon.airtime.fragments.InterestGroupsFragment;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (findViewById(R.id.contentContainer) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentContainer, new
                    ChatsFragment()).commit();
        }


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    if (findViewById(R.id.contentContainer) != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id
                                .contentContainer, new ChatsFragment()).commit();
                    }
//                    // The tab with id R.id.tab_favorites was selected,
//                    // change your content accordingly.
                } else if (tabId == R.id.tab_groups) {
                    if (findViewById(R.id.contentContainer) != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id
                                .contentContainer, new InterestGroupsFragment()).commit();
                    }
                }
            }
        });
    }


}

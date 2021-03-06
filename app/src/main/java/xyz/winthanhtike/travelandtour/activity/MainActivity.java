package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.data.vos.UpgradeItemVO;
import xyz.winthanhtike.travelandtour.fragment.AboutUsFragment;
import xyz.winthanhtike.travelandtour.fragment.AgilityFragment;
import xyz.winthanhtike.travelandtour.fragment.BasicItemFragment;
import xyz.winthanhtike.travelandtour.fragment.IntelligenceFragment;
import xyz.winthanhtike.travelandtour.fragment.ItemFragment;
import xyz.winthanhtike.travelandtour.fragment.HomeFragment;
import xyz.winthanhtike.travelandtour.fragment.StrengthFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ItemFragment.ControllerItem,HomeFragment.ControllerHero{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, homeFragment).commit();

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                query =  query.toLowerCase();

                final List<HeroVO> filterList = new ArrayList<HeroVO>();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){

            case R.id.nav_home:
                toolbar.setTitle("Dota 2 Hero");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container,new HomeFragment())
                        .commit();
                break;

            case R.id.nav_item:
                toolbar.setTitle("Dota 2 Item");
                ItemFragment itemFragment = new ItemFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, itemFragment)
                        .commit();
                break;

            case R.id.nav_about_me:
                toolbar.setTitle("About Me");
                AboutUsFragment aboutUsFragment = new AboutUsFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, aboutUsFragment)
                        .commit();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onTapBasicItem(BasicItemVO basicItemVO, ImageView ivBasicItemImage) {
        Intent intent = BasicItemDetailActivity.newInstance(basicItemVO.getbItemName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(ivBasicItemImage,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }

    @Override
    public void onTapUpgradeItem(UpgradeItemVO upgradeItemVO, ImageView ivUpgradeImage) {
        Intent intent = UpgradeItemDetailActivity.newInstance(upgradeItemVO.getItemName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(ivUpgradeImage,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }

    @Override
    public void onTapStrengthHero(HeroVO hero, ImageView ivHeroImage) {
        Intent intent = StrengthHeroDetailActivity.newInstance(hero.getHeroName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(ivHeroImage,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }

    @Override
    public void onTapAgilityHero(HeroVO heroVO, ImageView imageView) {
        Intent intent = AgilityHeroDetailActivity.newInstance(heroVO.getHeroName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(imageView,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }

    @Override
    public void onTapIntellHero(HeroVO heroVO, ImageView imageView) {
        Intent intent = IntelligenceHeroDetailActivity.newInstance(heroVO.getHeroName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(imageView,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }
}

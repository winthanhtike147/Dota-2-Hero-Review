package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.db.DataContract;
import xyz.winthanhtike.travelandtour.model.IntelligenceHero;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class IntelligenceHeroDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView tvOverview,tvDetail,tvToolbarTitle;
    private ImageView imgHero;
    private IntelligenceHero intelligenceHero;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_container);

        Intent intent = getIntent();
        intelligenceHero = (IntelligenceHero) intent.getSerializableExtra(DataContract.IntelligenceTable.TABLE_NAME);

        configsView();

        tvOverview.setText(intelligenceHero.getiHeroOverview());
        tvDetail.setText(intelligenceHero.getiHeroDetail());
        tvToolbarTitle.setText(intelligenceHero.getiHeroName());
        Picasso.with(getApplicationContext()).load(intelligenceHero.getiHeroImageUrl()).error(R.mipmap.ic_launcher).into(imgHero);

    }

    private void configsView() {

        tvOverview = (TextView)findViewById(R.id.tv_overview);
        tvDetail = (TextView)findViewById(R.id.tv_detail);
        imgHero = (ImageView)findViewById(R.id.col_img_hero);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);
        toolbarAndTitle();

    }

    private void toolbarAndTitle() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

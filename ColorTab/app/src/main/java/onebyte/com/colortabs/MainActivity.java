package onebyte.com.colortabs;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import onebyte.com.colormatchingtabsjava.java.adapter.ColorTabAdapter;
import onebyte.com.colormatchingtabsjava.java.colortabs.ColorMatchTabLayout;
import onebyte.com.colormatchingtabsjava.java.listeners.ColorTabLayoutOnPageChangeListener;
import onebyte.com.colormatchingtabsjava.java.listeners.OnColorTabSelectedListener;
import onebyte.com.colormatchingtabsjava.java.model.ColorTab;
import onebyte.com.colortabs.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    public ColorMatchTabLayout colorMatchTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        colorMatchTabLayout = (ColorMatchTabLayout) findViewById(R.id.colorMatchTabLayout);
        toolbarTitle.setTextColor(ContextCompat.getColor(this, R.color.colorGreen));
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setBackgroundColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        String colorsArray[] = getResources().getStringArray(R.array.colors);
        TypedArray iconsArray = getResources().obtainTypedArray(R.array.icons);
        String textsArray[] = getResources().getStringArray(R.array.texts);
        int i = 0;
        colorMatchTabLayout.setBackgroundColor(Color.WHITE);
        ColorTabAdapter colorTabAdapter = new ColorTabAdapter();
        for (String color : colorsArray) {
            String tabName = textsArray[i];
            int selectedColor = Color.parseColor(color);
            Drawable icon = iconsArray.getDrawable(i);
            colorMatchTabLayout.addTab(colorTabAdapter.createColorTab(colorMatchTabLayout, tabName, selectedColor, icon));
            i++;
        }
        viewPager.setAdapter(new ColorTabsAdapter(getSupportFragmentManager(), colorMatchTabLayout.count()));
        viewPager.addOnPageChangeListener(new ColorTabLayoutOnPageChangeListener(colorMatchTabLayout));
        viewPager.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
        viewPager.getBackground().setAlpha(128);
        OnColorTabSelectedListener listen = new OnColorTabSelectedListener() {
            @Override
            public void onSelectedTab(ColorTab tab) {
                viewPager.setCurrentItem(tab.position);
               //For Scroll ColorMatchTab to Position of ViewPager
                switch (tab.position) {
                    case 0:
                        colorMatchTabLayout.scrollTo(0, 0);
                        break;
                    case 1:
                        colorMatchTabLayout.scrollTo(colorMatchTabLayout.selectedTabWidth, 0);
                        break;
                    case 2:
                        colorMatchTabLayout.scrollTo(colorMatchTabLayout.selectedTabWidth * 2, 0);
                        break;
                    case 3:
                        colorMatchTabLayout.scrollTo(colorMatchTabLayout.selectedTabWidth * 3, 0);
                        break;
                    case 4:
                        colorMatchTabLayout.scrollTo(colorMatchTabLayout.selectedTabWidth * 4, 0);
                        break;
                    case 5:
                        colorMatchTabLayout.scrollTo(colorMatchTabLayout.selectedTabWidth * 5, 0);
                        break;
                }
                    viewPager.setBackgroundColor(tab.selectedColor);
                viewPager.getBackground().setAlpha(128);
                toolbarTitle.setTextColor(tab.selectedColor);
            }

            @Override
            public void onUnselectedTab(ColorTab tab) {
                Log.e("Unselected ", "tab");

            }
        };
        colorMatchTabLayout.addOnColorTabSelectedListener(listen);
    }

        @Override
        public boolean onCreateOptionsMenu(android.view.Menu menu)
        {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
}


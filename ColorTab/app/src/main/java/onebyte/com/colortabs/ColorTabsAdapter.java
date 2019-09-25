package onebyte.com.colortabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ColorTabsAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;
    private int amountTabs;

        public ColorTabsAdapter(FragmentManager fragmentManager, int amountTabs)
    {
        super(fragmentManager);
        this.amountTabs = amountTabs;
        this.fragmentManager = fragmentManager;
    }

    public Fragment getItem(int position) {
       return  ListItemsFragment.newInstance();
    }
    public int getCount(){
        return amountTabs;
    }
}

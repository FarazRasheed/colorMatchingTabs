package onebyte.com.colortabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import onebyte.com.colortabs.model.Menu;


public class ListItemsFragment extends Fragment {


    public static Fragment newInstance(){
            return new ListItemsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_list_items, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView menuList =(RecyclerView) view.findViewById(R.id.menuList);
        menuList.setLayoutManager(new LinearLayoutManager(getContext()));
        ListItemAdapter adapter = new ListItemAdapter(getContext(), createListItems());
        menuList.setAdapter(adapter);
    }

    public List<Menu> createListItems(){
        List<Menu> list = new ArrayList<>();
        list.add(new Menu(R.drawable.eat, "Caesar Salad", "Cafe de Gargadem" , "12.3K Reviews"));
        list.add(new Menu(R.drawable.coffe, "Latte Macchiato", "Cafe de Gargadem" , "12.3K Reviews"));
        list.add(new Menu(R.drawable.eat, "Caesar Salad", "Cafe de Gargadem" , "12.3K Reviews"));
        list.add(new Menu(R.drawable.coffe, "Latte Macchiato", "Cafe de Gargadem" , "12.3K Reviews"));
        list.add(new Menu(R.drawable.eat, "Caesar Salad", "Cafe de Gargadem" , "12.3K Reviews"));
        list.add(new Menu(R.drawable.coffe, "Latte Macchiato", "Cafe de Gargadem" , "12.3K Reviews"));
        return list;
    }

}

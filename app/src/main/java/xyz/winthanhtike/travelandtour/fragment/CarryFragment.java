package xyz.winthanhtike.travelandtour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.winthanhtike.travelandtour.R;

/**
 * Created by winthanhtike on 6/23/16.
 */
public class CarryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.carry_fragment,container,false);
        return view;

    }
}

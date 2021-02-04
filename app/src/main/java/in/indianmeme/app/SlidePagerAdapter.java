package in.indianmeme.app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class SlidePagerAdapter extends FragmentPagerAdapter {

    private List<ModelClass> _list;

    public SlidePagerAdapter(@NonNull FragmentManager fm, int behavior, List<ModelClass> _list) {
        super(fm, behavior);
        this._list = _list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ModelClass modelClass = _list.get(position);
        FragmentOne fragmentOne = new FragmentOne();
        fragmentOne.setTitle(modelClass.getOne());
        fragmentOne.setText(modelClass.getTwo());
        return fragmentOne;
    }

    @Override
    public int getCount() {
        return _list.size();
    }
}

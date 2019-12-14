package in.dotworld.viewer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class imageView extends Fragment {

    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_view, container, false);

        ImageView iv=rootView.findViewById(R.id.imageview);
        return rootView;
    }




}

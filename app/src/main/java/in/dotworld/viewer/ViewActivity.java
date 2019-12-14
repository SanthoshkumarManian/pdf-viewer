package in.dotworld.viewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ViewActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {
PDFView pdfview;
Uri selectedpdf;
int pagenumber;
FragmentManager fg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_view);


        init();
    }
    private void init()
    {
        pdfview=findViewById(R.id.pdfviewer1);
        String selectedpdf= getIntent().getStringExtra("URL");
        Uri pdf=Uri.parse(selectedpdf);
            pdfview.fromUri(pdf).defaultPage(0)
                    .enableSwipe(true)
                    .swipeHorizontal(false).onPageChange(this).enableAnnotationRendering(true)
                    .onLoad(this).scrollHandle(new DefaultScrollHandle(this)).load();

    }

    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pagenumber=page;
        setTitle(String.format("%s / %s",page+1,pageCount));

    }
}

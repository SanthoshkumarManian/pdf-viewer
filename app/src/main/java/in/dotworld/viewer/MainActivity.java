package in.dotworld.viewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;

import java.io.File;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PDFView PdfView;
    File file;
    public static final int PICKFILE_REQUEST_CODE = 1000;
    public String selectedPdfPath;
    public  String filemanagerstring;
    int pagenumber;
    Uri selectedPdf;
    FragmentManager fg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.open);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
               intent.setType("*/*");
               intent.addCategory(Intent.CATEGORY_OPENABLE);
               startActivityForResult(intent, PICKFILE_REQUEST_CODE);
            }

        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {

            if (requestCode == PICKFILE_REQUEST_CODE)
            {

                selectedPdf = data.getData();
                Intent intent =new Intent(MainActivity.this,ViewActivity.class);
                intent.putExtra("URL",selectedPdf.toString());
                startActivity(intent);

            }

        }
        super.onActivityResult(requestCode,resultCode,data);
    }

}

package rktechltd.aklfishing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by romelyn on 16/05/2016.
 */
public class ImageHelper {
    public static byte[] convertImage(String imagePath) {
        byte[] data ;
        Bitmap src = BitmapFactory.decodeFile(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        src.compress(Bitmap.CompressFormat.PNG, 100, baos);
        data = baos.toByteArray();
        return data;
    }



}

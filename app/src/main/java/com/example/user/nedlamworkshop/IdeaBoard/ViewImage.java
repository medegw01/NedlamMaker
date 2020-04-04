package com.example.user.nedlamworkshop.IdeaBoard;

import android.graphics.Bitmap;

        import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;
import com.example.user.nedlamworkshop.helperclass.RequestHandler;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
        import java.net.URL;

/**
 * Created by Michael on 7/20/2016.
 */

public class ViewImage extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextId;
    private Button buttonGetImage;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);

        editTextId = (EditText) findViewById(R.id.imagename1);
        buttonGetImage = (Button) findViewById(R.id.downloadDimage);
        imageView = (ImageView) findViewById(R.id.dimage);

        RequestHandler requestHandler = new RequestHandler();

        buttonGetImage.setOnClickListener(this);
    }


    private void getImage() {
        //String id = editTextId.getText().toString().trim();
        class GetImage extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            JSONArray jsonArray;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewImage.this, "loading ideaboard...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                                //imageView.setImageBitmap(b);
                if (s != null){
                  //  jsonArray = new JSONArray<s>;


                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "unable to load ideaboard", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            protected String doInBackground(Void... params) {
                //String id = params[0];
                String add = "http://medegw01.esy.es/getImage.php?id";
                URL url;
                HttpURLConnection httpURLConnection;
                //Bitmap image = null;
                InputStream inputStream = null;
                String line = null;
                try {
                    url = new URL(add);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    StringBuffer stringBuffer = new StringBuffer();
                    if (bufferedReader != null) {
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuffer.append(line + "\n");
                        }
                    }else {
                            return null;}
                    return stringBuffer.toString();
                    //image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }

        GetImage gi = new GetImage();
       gi.execute();
    }
    @Override
    public void onClick(View v) {
        getImage();
    }
}
























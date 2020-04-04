package com.example.user.nedlamworkshop.IdeaBoard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Michael on 8/2/2016.
 */
public class view_IdeaA extends ActionBarActivity {

    private ListView listView;
    private final String URL_TO_HIT  = "http://medegw01.esy.es/NedlamViewIdeas.php";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            new GetImage().execute(URL_TO_HIT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ideaboard);

        listView = (ListView) findViewById(R.id.listview_ideaboard);
        new GetImage().execute(URL_TO_HIT);


    }

    public class GetImage extends AsyncTask<String,String, List<ideasStore>> {
        ProgressDialog loading;
        public String finalJson;
        public List<ideasStore> arrayList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(view_IdeaA.this, "loading ideaboard...", null, true, true);
        }

        @Override
        protected List<ideasStore> doInBackground(String... params) {

            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;

            try {
                URL url = new URL("http://medegw01.esy.es/NedlamViewIdeas.php");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    buffer.append(line);
                }

                finalJson = buffer.toString();

                //JSONObject parentObject = new JSONObject(finalJson);
                //JSONArray jsonArray = parentObject.getJSONArray("IdeaBoard");
                JSONArray jsonArray = new JSONArray(finalJson);

                arrayList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    ideasStore idt = new ideasStore();
                    String img_string = jsonObject.getString("image");
                    byte[] decodedString = Base64.decode(img_string, Base64.DEFAULT);
                    Bitmap image = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    idt.setImg(image);
                    idt.setDescription(jsonObject.getString("description"));
                    idt.setTitle(jsonObject.getString("title"));
                    arrayList.add(idt);

                }
                return arrayList;

                //image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ideasStore> result) {
            super.onPostExecute(result);
            loading.dismiss();

            Toast.makeText(getApplicationContext(), finalJson , Toast.LENGTH_LONG).show();

            if (result != null) {
                IdeaboardAdaptor adapter = new IdeaboardAdaptor(getApplicationContext(), R.layout.row, result);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
                    }
                });


            } else {
                Toast.makeText(getApplicationContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }


        public class IdeaboardAdaptor extends ArrayAdapter {
            private List<ideasStore> ideasStoresList;
            private int resource;
            private LayoutInflater layoutInflater;

            public IdeaboardAdaptor(Context context, int resource, List<ideasStore> objects) {
                super(context, resource, objects);
                ideasStoresList = objects;
                this.resource = resource;
                layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ViewHolder holder = null;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = layoutInflater.inflate(resource, null);

                    holder.ivMovieIcon = (ImageView) convertView.findViewById(R.id.ideaboard_image);
                    holder.title = (TextView) convertView.findViewById(R.id.ideaboard_tiltle);
                    holder.description = (TextView) convertView.findViewById(R.id.ideaboard_description);
                 convertView.setTag(holder);
                }
                else {
                    holder  = (ViewHolder) convertView.getTag();
                }


                holder.ivMovieIcon.setImageBitmap(ideasStoresList.get(position).getImg());
                holder.title.setText(ideasStoresList.get(position).getTitle() + ":");
                holder.description.setText(ideasStoresList.get(position).getDescription());
                return convertView;
            }
            class ViewHolder{
                private ImageView ivMovieIcon;
                private TextView title;
                private TextView description;
                           }
        }
    }

}



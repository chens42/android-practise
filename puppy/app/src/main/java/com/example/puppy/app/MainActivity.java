package com.example.puppy.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    private static String url = "http://api.androidhive.info/contacts/";
    ArrayList<HashMap<String, String>> contactList;
    ArrayList<RowInfo> rowInfoArrayList = new ArrayList<RowInfo>();
    ShowAdaptor adapter = null;
    ListView listView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = new ArrayList<HashMap<String, String>>();
        new getContent().execute();
    }

    public class getContent extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... arg0) {
//            ServiceHandler sh = new ServiceHandler();
//            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet= new HttpGet(url);
            HttpResponse httpResponse;
            HttpEntity httpEntity;
            String jsonStr=null;
            try {
                httpResponse=httpClient.execute(httpGet);
                httpEntity = httpResponse.getEntity();
                jsonStr = EntityUtils.toString(httpEntity);
                Log.e("httpEntity",jsonStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsonStr !=null){
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(jsonStr);
                    JSONArray contacts = jsonObject.getJSONArray("contacts");
                    for (int i=0;i<contacts.length();i++){
                        JSONObject obj= contacts.getJSONObject(i);
                        String id = obj.getString("id");
                        String name=obj.getString("name");
                        String email=obj.getString("email");
                        String address = obj.getString("address");
                        String gender= obj.getString("gender");
                        JSONObject phone = obj.getJSONObject("phone");
                        String mobilePhone = phone.getString("mobile");
                        String homePhone = phone.getString("home");
                        String officePhone = phone.getString("office");
                        RowInfo rowInfo = new RowInfo(id,name,email,address,gender,mobilePhone,homePhone,officePhone);
                        rowInfoArrayList.add(rowInfo);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            ListAdapter adapter = new SimpleAdapter(
//                    MainActivity.this, contactList,
//                    R.layout.list_item, new String[] {"title","description","name","timezone","cname"}, new int[] { R.id.title,
//                    R.id.description, R.id.name,R.id.timezone,R.id.cname });
//
//            setListAdapter(adapter);
            adapter = new ShowAdaptor();
            listView=(ListView) findViewById(R.id.list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ShowAdaptor extends ArrayAdapter{
        public ShowAdaptor() {
            super(MainActivity.this,R.layout.list_item,rowInfoArrayList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ShopHolder holder;

            if(row == null){
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.list_item,parent,false);
                holder = new ShopHolder(row);
                row.setTag(holder);
            }else{
                holder=(ShopHolder) row.getTag();
            }
            holder.add(rowInfoArrayList.get(position));
            return row;
        }
    }
}

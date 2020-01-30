package tomi.jsontehtava;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import tomi.jsontehtava.MainActivity;

public class GetRawData extends AsyncTask<Void, Void, JSONArray>
{
    @Override
    protected JSONArray doInBackground(Void... params)
    {

        String str="https://jsonplaceholder.typicode.com/posts";
        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        try
        {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }

            return new JSONArray(stringBuffer.toString());
        }
        catch(Exception ex)
        {
            Log.e("App", "yourDataTask", ex);
            return null;
        }
        finally
        {
            if(bufferedReader != null)
            {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPostExecute(JSONArray response)
    {
        if(response != null)
        {
            try {
                
                for (int i = 0; i < response.length(); i++) {
                    JSONObject c = response.getJSONObject(i);
                    Log.e("Object ID: ",c.getString("id"));
                    String title = c.getString("title");
                    String body = c.getString("body");
                    int id = c.getInt("id");
                    int userId = c.getInt("userId");
                    NaytettavaLuokka nl = new NaytettavaLuokka(title,userId,id,body);
                    if(nl != null){
                        MainActivity.lista.add(nl);
                    }else{
                        Log.e("nulli nl objekti", "onPostExecute: ");
                    }

                }
                Log.e("App", "Success: " );
            } catch (Exception ex) {
                Log.e("App", "Failure", ex);
            }
        }
    }
}
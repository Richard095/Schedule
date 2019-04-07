package com.example.schedule;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class DataAsyncTask extends AsyncTask<Void,Void,String> {


    //Interface for send data to fragment
    public dataSubject delegate;

    public interface dataSubject{
        void dataDownoaded(String data);
    }

    @Override
    protected String doInBackground(Void... voids) {
        String data = "";
        try {
            data= downladeData(new URL("http://192.168.1.105/APISERVICE/index.php"));
        }catch(IOException e){e.printStackTrace();}
        return data;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        delegate.dataDownoaded(s);
    }


    private String downladeData(URL url) throws IOException {

        String jsonResponse="";
        HttpURLConnection urlConnection = null;
        InputStream inputStream=null;

        try {

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);


        }catch(IOException e){

        }finally {
            if (urlConnection!=null){
                urlConnection.disconnect();
            }
            if (inputStream != null){
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return  output.toString();
    }
}

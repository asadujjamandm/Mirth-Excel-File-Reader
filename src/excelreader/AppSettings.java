package excelreader;


import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.gson.Gson;

public class AppSettings {
    public String Filepath;

    public AppSettings GetAppConfig(){
        var path = System.getProperty("user.dir") + "\\config.json";

        try(FileReader reader = new FileReader(path)){
            Gson gson = new Gson();
            AppSettings appSettings = gson.fromJson(reader, AppSettings.class);

            return appSettings;
        }
        catch(Exception e){ 
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            String stackTrace = sw.toString();          
            return null;
        }
    }
}

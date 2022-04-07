package excelreader;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;


public class AppSettings {
    public String Filepath;

    public AppSettings GetAppConfig(){
        var path = "D:\\Projects\\Mirth Excel File Reader\\Mirth-Excel-File-Reader\\excelreader_config.json";

        try{
            String fileContent = new String(Files.readAllBytes(Paths.get(path)));
            
            ObjectMapper mapper = new ObjectMapper();
            //String jsonString = reader.toString();

            System.out.println(fileContent);
            AppSettings appSettings =mapper.readValue(fileContent, AppSettings.class);
            
            //Gson gson = new Gson();
            //AppSettings appSettings = gson.fromJson(reader, AppSettings.class);
            
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

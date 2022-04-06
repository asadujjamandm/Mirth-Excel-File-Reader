package excelreader;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;



public class ExcelReader {

    private AppSettings _appSettings;
    private List<CrossRef> _crossRef;
    public ExcelReader(){
        _appSettings=_appSettings.GetAppConfig();
    }
    private void GetExcel(){

        try {             
            File file = new File(_appSettings.Filepath);
		    _crossRef = Poiji.fromExcel(file, CrossRef.class);		    
        }

        catch(Exception ex){

            ex.printStackTrace();

        } 
    }

    public String GetCrossType(String facilityID){
        var crossRefType = "AL";
        this.GetExcel();        
        for (var crossRef : _crossRef) {                        
            if(crossRef.FacilityId.equals(facilityID)){
                crossRefType = crossRef.SNORAL;
                break;
            }            
        }

        return crossRefType;
    }

}

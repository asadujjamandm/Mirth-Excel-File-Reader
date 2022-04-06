package excelreader;

import java.util.Properties;

import com.poiji.annotation.ExcelCellName;

public class CrossRef {
    @ExcelCellName("Facililty ID")
    public String FacilityId;
    @ExcelCellName("Skilled Nursing (SN) or Assisted Living (AL)")
    public String SNORAL;
}

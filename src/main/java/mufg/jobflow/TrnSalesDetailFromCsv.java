package mufg.jobflow;

import mufg.modelgen.dmdl.csv.AbstractTrnSalesDetailCsvImporterDescription;

/**
 * 売上明細をWindGate/CSVからインポートする。
 */
public class TrnSalesDetailFromCsv extends
		AbstractTrnSalesDetailCsvImporterDescription {

	   @Override
	    public String getProfileName() {
	        return "asakusa";
	    }
	 
	    @Override
	    public String getPath() {
	        return "hands_on/input/trn_sales_detail.tsv";
	    }
	 
	    @Override
	    public DataSize getDataSize() {
	        return DataSize.LARGE;
	    }
}

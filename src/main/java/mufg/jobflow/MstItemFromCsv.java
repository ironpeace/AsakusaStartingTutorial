package mufg.jobflow;

import mufg.modelgen.dmdl.csv.AbstractMstItemCsvImporterDescription;

/**
 * 商品マスタをWindGate/CSVからインポートする。
 */
public class MstItemFromCsv extends AbstractMstItemCsvImporterDescription {

    @Override
    public String getProfileName() {
        return "asakusa";
    }
 
    @Override
    public String getPath() {
        return "hands_on/input/mst_item.tsv";
    }
 
    @Override
    public DataSize getDataSize() {
        return DataSize.LARGE;
    }
}

package mufg.jobflow;

import mufg.modelgen.dmdl.csv.AbstractItemSalesSummaryCsvExporterDescription;

/**
 * 商品ごとの販売数量WindGate／CSVでエクスポート
 */
public class ItemSalesSummaryToCsv extends
		AbstractItemSalesSummaryCsvExporterDescription {

    @Override
    public String getProfileName() {
        return "asakusa";
    }

    @Override
    public String getPath() {
        return "hands_on/output/item_sales_summary.csv";
    }
}

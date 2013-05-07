package mufg.batch;

import mufg.jobflow.JfItemSalesSummary;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;

@Batch(name = "Day2ItemSummary")
public class BtSummarize extends BatchDescription {
 
    @Override
    protected void describe() {
        run(JfItemSalesSummary.class).soon();
    }
}

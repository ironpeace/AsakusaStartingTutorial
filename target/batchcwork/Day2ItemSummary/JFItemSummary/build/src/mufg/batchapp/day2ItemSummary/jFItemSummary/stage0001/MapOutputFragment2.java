package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * {@code trnSalesDetal->ItemSalesSummaryOperator.joinItem(operator#454514340)}へのシャッフル処理を担当するプログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapOutputFragment2 implements Result<TrnSalesDetail> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    /**
     * インスタンスを生成する。
     * @param collector 実際の出力先
     */
    public MapOutputFragment2(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(TrnSalesDetail result) {
        this.key.setPort2(result);
        this.value.setPort2(result);
        try {
            this.collector.write(this.key, this.value);
        }
        catch(Exception exception) {
            throw new Result.OutputException(exception);
        }
    }
}
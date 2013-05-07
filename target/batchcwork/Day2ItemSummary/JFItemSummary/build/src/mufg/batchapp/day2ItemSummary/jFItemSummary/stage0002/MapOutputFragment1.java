package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0002;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * {@code joinedSalesItem->ItemSalesSummaryOperator.summarizeByCategory(operator#1860404380)}へのシャッフル処理を担当するプログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapOutputFragment1 implements Result<JoinedSalesItem> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    private ItemSalesSummary cache = new ItemSalesSummary();
    /**
     * インスタンスを生成する。
     * @param collector 実際の出力先
     */
    public MapOutputFragment1(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(JoinedSalesItem result) {
        this.cache.setItemIdOption(result.getItemIdOption());
        this.cache.setItemNameOption(result.getItemNameOption());
        this.cache.getAmountTotalOption().modify(result.getAmountOption().get());
        this.key.setPort1(this.cache);
        this.value.setPort1(this.cache);
        try {
            this.collector.write(this.key, this.value);
        }
        catch(Exception exception) {
            throw new Result.OutputException(exception);
        }
    }
}
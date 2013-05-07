package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0002;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
/**
 * {@code [joinedSalesItem->ItemSalesSummaryOperator.summarizeByCategory(operator#1860404380)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class ReduceFragment2 extends com.asakusafw.runtime.flow.Rendezvous<
        ShuffleValue> {
    private final Result<ItemSalesSummary> out;
    private boolean initialized;
    private ItemSalesSummary cache = new ItemSalesSummary();
    /**
     * インスタンスを生成する。
     * @param out {@code ItemSalesSummaryOperator.summarizeByCategory#out}への出力
     */
    public ReduceFragment2(Result<ItemSalesSummary> out) {
        this.out = out;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.initialized = false;
    }
    @Override public void end() {
        this.out.add(this.cache);
    }
    private void process0001(ItemSalesSummary value) {
        if(this.initialized) {
            this.cache.getAmountTotalOption().add(value.getAmountTotalOption());
        }
        else {
            this.cache.copyFrom(value);
            this.initialized = true;
        }
    }
}
package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
import mufg.modelgen.dmdl.model.MstItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * {@code 
         * [mstItem->ItemSalesSummaryOperator.joinItem(operator#454514340), trnSalesDetal->ItemSalesSummaryOperator.joinItem(operator#454514340)]
         * }の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class ReduceFragment3 extends com.asakusafw.runtime.flow.Rendezvous<
        ShuffleValue> {
    private final Result<JoinedSalesItem> joined;
    private final Result<TrnSalesDetail> missed;
    private boolean sawMaster;
    private MstItem cache = new MstItem();
    private JoinedSalesItem cache0 = new JoinedSalesItem();
    /**
     * インスタンスを生成する。
     * @param joined {@code ItemSalesSummaryOperator.joinItem#joined}への出力
     * @param missed {@code ItemSalesSummaryOperator.joinItem#missed}への出力
     */
    public ReduceFragment3(Result<JoinedSalesItem> joined, Result<TrnSalesDetail> missed) {
        this.joined = joined;
        this.missed = missed;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            case 2:
                this.process0002(value.getPort2());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.sawMaster = false;
    }
    @Override public void end() {
    }
    private void process0001(MstItem value) {
        if(this.sawMaster == false) {
            this.cache.copyFrom(value);
            this.sawMaster = true;
        }
    }
    private void process0002(TrnSalesDetail value) {
        if(this.sawMaster) {
            this.cache0.reset();
            this.cache0.setSalesDetailIdOption(value.getSalesDetailIdOption());
            this.cache0.setAmountOption(value.getAmountOption());
            this.cache0.setItemIdOption(value.getItemIdOption());
            this.cache0.setItemNameOption(this.cache.getItemNameOption());
            this.joined.add(this.cache0);
        }
        else {
            this.missed.add(value);
        }
    }
}
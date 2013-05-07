package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * {@code [in->padding(pseud#263851830)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<TrnSalesDetail> {
    private final Result<TrnSalesDetail> out;
    /**
     * インスタンスを生成する。
     * @param out {@code padding#out}への出力
     */
    public MapFragment1(Result<TrnSalesDetail> out) {
        this.out = out;
    }
    @Override public void add(TrnSalesDetail result) {
        this.out.add(result);
    }
}
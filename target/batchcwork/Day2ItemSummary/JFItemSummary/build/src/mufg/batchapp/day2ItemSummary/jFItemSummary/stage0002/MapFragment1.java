package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0002;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
/**
 * {@code [in->padding(pseud#682820082)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<JoinedSalesItem> {
    private final Result<JoinedSalesItem> out;
    /**
     * インスタンスを生成する。
     * @param out {@code padding#out}への出力
     */
    public MapFragment1(Result<JoinedSalesItem> out) {
        this.out = out;
    }
    @Override public void add(JoinedSalesItem result) {
        this.out.add(result);
    }
}
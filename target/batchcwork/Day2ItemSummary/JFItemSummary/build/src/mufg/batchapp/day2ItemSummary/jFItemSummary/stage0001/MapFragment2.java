package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.core.Result;
import mufg.modelgen.dmdl.model.MstItem;
/**
 * {@code [in->padding(pseud#1720854532)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment2 implements Result<MstItem> {
    private final Result<MstItem> out;
    /**
     * インスタンスを生成する。
     * @param out {@code padding#out}への出力
     */
    public MapFragment2(Result<MstItem> out) {
        this.out = out;
    }
    @Override public void add(MstItem result) {
        this.out.add(result);
    }
}
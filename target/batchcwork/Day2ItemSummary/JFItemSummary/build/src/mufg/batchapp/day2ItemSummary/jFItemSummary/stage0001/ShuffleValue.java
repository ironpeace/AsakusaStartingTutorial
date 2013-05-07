package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.flow.SegmentedWritable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mufg.modelgen.dmdl.model.MstItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * ステージ#1シャッフルで利用する値クラス。
 */
@SuppressWarnings("deprecation") public final class ShuffleValue implements SegmentedWritable {
    /**
     * セグメント番号。
     */
    public int segmentId = -1;
    @Override public int getSegmentId() {
        return this.segmentId;
    }
    /**
     * ItemSalesSummaryOperator.joinItem#mstItemが利用するモデル (1)。
     */
    public MstItem port0001 = new MstItem();
    /**
     * ItemSalesSummaryOperator.joinItem#trnSalesDetalが利用するモデル (2)。
     */
    public TrnSalesDetail port0002 = new TrnSalesDetail();
    /**
     * ItemSalesSummaryOperator.joinItem#mstItemのモデルオブジェクトを返す。
     */
    public MstItem getPort1() {
        if(this.segmentId != 1) throw new AssertionError();
        return this.port0001;
    }
    /**
     * ItemSalesSummaryOperator.joinItem#mstItemで使用するモデルオブジェクトを設定する。
     * @param model 設定するモデルオブジェクト
     */
    public void setPort1(MstItem model) {
        this.segmentId = 1;
        this.port0001.copyFrom(model);
    }
    /**
     * ItemSalesSummaryOperator.joinItem#trnSalesDetalのモデルオブジェクトを返す。
     */
    public TrnSalesDetail getPort2() {
        if(this.segmentId != 2) throw new AssertionError();
        return this.port0002;
    }
    /**
     * ItemSalesSummaryOperator.joinItem#trnSalesDetalで使用するモデルオブジェクトを設定する。
     * @param model 設定するモデルオブジェクト
     */
    public void setPort2(TrnSalesDetail model) {
        this.segmentId = 2;
        this.port0002.copyFrom(model);
    }
    @Override public void write(DataOutput out) throws IOException {
        switch(this.segmentId) {
            case 1:
                out.writeInt(1);
                this.port0001.write(out);
                break;
            case 2:
                out.writeInt(2);
                this.port0002.write(out);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
    @Override public void readFields(DataInput in) throws IOException {
        this.segmentId = in.readInt();
        switch(this.segmentId) {
            case 1:
                this.port0001.readFields(in);
                break;
            case 2:
                this.port0002.readFields(in);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
}
package mufg.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.LongOption;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mufg.modelgen.dmdl.io.TrnSalesDetailInput;
import mufg.modelgen.dmdl.io.TrnSalesDetailOutput;
import org.apache.hadoop.io.Writable;
/**
 * 売上明細を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(TrnSalesDetailInput.class)@ModelOutputLocation(TrnSalesDetailOutput.class)@
        PropertyOrder({"sales_detail_id", "slip_id", "item_id", "amount"}) public class TrnSalesDetail implements 
        DataModel<TrnSalesDetail>, Writable {
    private final LongOption salesDetailId = new LongOption();
    private final LongOption slipId = new LongOption();
    private final LongOption itemId = new LongOption();
    private final LongOption amount = new LongOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.salesDetailId.setNull();
        this.slipId.setNull();
        this.itemId.setNull();
        this.amount.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(TrnSalesDetail other) {
        this.salesDetailId.copyFrom(other.salesDetailId);
        this.slipId.copyFrom(other.slipId);
        this.itemId.copyFrom(other.itemId);
        this.amount.copyFrom(other.amount);
    }
    /**
     * 売上明細IDを返す。
     * @return 売上明細ID
     * @throws NullPointerException 売上明細IDの値が<code>null</code>である場合
     */
    public long getSalesDetailId() {
        return this.salesDetailId.get();
    }
    /**
     * 売上明細IDを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setSalesDetailId(long value) {
        this.salesDetailId.modify(value);
    }
    /**
     * <code>null</code>を許す売上明細IDを返す。
     * @return 売上明細ID
     */
    public LongOption getSalesDetailIdOption() {
        return this.salesDetailId;
    }
    /**
     * 売上明細IDを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setSalesDetailIdOption(LongOption option) {
        this.salesDetailId.copyFrom(option);
    }
    /**
     * 伝票IDを返す。
     * @return 伝票ID
     * @throws NullPointerException 伝票IDの値が<code>null</code>である場合
     */
    public long getSlipId() {
        return this.slipId.get();
    }
    /**
     * 伝票IDを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setSlipId(long value) {
        this.slipId.modify(value);
    }
    /**
     * <code>null</code>を許す伝票IDを返す。
     * @return 伝票ID
     */
    public LongOption getSlipIdOption() {
        return this.slipId;
    }
    /**
     * 伝票IDを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setSlipIdOption(LongOption option) {
        this.slipId.copyFrom(option);
    }
    /**
     * 商品IDを返す。
     * @return 商品ID
     * @throws NullPointerException 商品IDの値が<code>null</code>である場合
     */
    public long getItemId() {
        return this.itemId.get();
    }
    /**
     * 商品IDを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemId(long value) {
        this.itemId.modify(value);
    }
    /**
     * <code>null</code>を許す商品IDを返す。
     * @return 商品ID
     */
    public LongOption getItemIdOption() {
        return this.itemId;
    }
    /**
     * 商品IDを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemIdOption(LongOption option) {
        this.itemId.copyFrom(option);
    }
    /**
     * 数量を返す。
     * @return 数量
     * @throws NullPointerException 数量の値が<code>null</code>である場合
     */
    public long getAmount() {
        return this.amount.get();
    }
    /**
     * 数量を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAmount(long value) {
        this.amount.modify(value);
    }
    /**
     * <code>null</code>を許す数量を返す。
     * @return 数量
     */
    public LongOption getAmountOption() {
        return this.amount;
    }
    /**
     * 数量を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAmountOption(LongOption option) {
        this.amount.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=trn_sales_detail");
        result.append(", salesDetailId=");
        result.append(this.salesDetailId);
        result.append(", slipId=");
        result.append(this.slipId);
        result.append(", itemId=");
        result.append(this.itemId);
        result.append(", amount=");
        result.append(this.amount);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + salesDetailId.hashCode();
        result = prime * result + slipId.hashCode();
        result = prime * result + itemId.hashCode();
        result = prime * result + amount.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        TrnSalesDetail other = (TrnSalesDetail) obj;
        if(this.salesDetailId.equals(other.salesDetailId) == false) {
            return false;
        }
        if(this.slipId.equals(other.slipId) == false) {
            return false;
        }
        if(this.itemId.equals(other.itemId) == false) {
            return false;
        }
        if(this.amount.equals(other.amount) == false) {
            return false;
        }
        return true;
    }
    @Override public void write(DataOutput out) throws IOException {
        salesDetailId.write(out);
        slipId.write(out);
        itemId.write(out);
        amount.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        salesDetailId.readFields(in);
        slipId.readFields(in);
        itemId.readFields(in);
        amount.readFields(in);
    }
}
package mufg.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.LongOption;
import com.asakusafw.runtime.value.StringOption;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mufg.modelgen.dmdl.io.MstItemInput;
import mufg.modelgen.dmdl.io.MstItemOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * 商品マスタを表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(MstItemInput.class)@ModelOutputLocation(MstItemOutput.class)@PropertyOrder({
            "item_id", "item_name", "unit_price", "cost_price", "stock_amount"}) public class MstItem implements 
        DataModel<MstItem>, Writable {
    private final LongOption itemId = new LongOption();
    private final StringOption itemName = new StringOption();
    private final LongOption unitPrice = new LongOption();
    private final LongOption costPrice = new LongOption();
    private final LongOption stockAmount = new LongOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.itemId.setNull();
        this.itemName.setNull();
        this.unitPrice.setNull();
        this.costPrice.setNull();
        this.stockAmount.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(MstItem other) {
        this.itemId.copyFrom(other.itemId);
        this.itemName.copyFrom(other.itemName);
        this.unitPrice.copyFrom(other.unitPrice);
        this.costPrice.copyFrom(other.costPrice);
        this.stockAmount.copyFrom(other.stockAmount);
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
     * 商品名を返す。
     * @return 商品名
     * @throws NullPointerException 商品名の値が<code>null</code>である場合
     */
    public Text getItemName() {
        return this.itemName.get();
    }
    /**
     * 商品名を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemName(Text value) {
        this.itemName.modify(value);
    }
    /**
     * <code>null</code>を許す商品名を返す。
     * @return 商品名
     */
    public StringOption getItemNameOption() {
        return this.itemName;
    }
    /**
     * 商品名を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemNameOption(StringOption option) {
        this.itemName.copyFrom(option);
    }
    /**
     * 商品単価を返す。
     * @return 商品単価
     * @throws NullPointerException 商品単価の値が<code>null</code>である場合
     */
    public long getUnitPrice() {
        return this.unitPrice.get();
    }
    /**
     * 商品単価を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setUnitPrice(long value) {
        this.unitPrice.modify(value);
    }
    /**
     * <code>null</code>を許す商品単価を返す。
     * @return 商品単価
     */
    public LongOption getUnitPriceOption() {
        return this.unitPrice;
    }
    /**
     * 商品単価を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setUnitPriceOption(LongOption option) {
        this.unitPrice.copyFrom(option);
    }
    /**
     * 商品原価を返す。
     * @return 商品原価
     * @throws NullPointerException 商品原価の値が<code>null</code>である場合
     */
    public long getCostPrice() {
        return this.costPrice.get();
    }
    /**
     * 商品原価を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setCostPrice(long value) {
        this.costPrice.modify(value);
    }
    /**
     * <code>null</code>を許す商品原価を返す。
     * @return 商品原価
     */
    public LongOption getCostPriceOption() {
        return this.costPrice;
    }
    /**
     * 商品原価を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setCostPriceOption(LongOption option) {
        this.costPrice.copyFrom(option);
    }
    /**
     * 在庫数量を返す。
     * @return 在庫数量
     * @throws NullPointerException 在庫数量の値が<code>null</code>である場合
     */
    public long getStockAmount() {
        return this.stockAmount.get();
    }
    /**
     * 在庫数量を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setStockAmount(long value) {
        this.stockAmount.modify(value);
    }
    /**
     * <code>null</code>を許す在庫数量を返す。
     * @return 在庫数量
     */
    public LongOption getStockAmountOption() {
        return this.stockAmount;
    }
    /**
     * 在庫数量を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setStockAmountOption(LongOption option) {
        this.stockAmount.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=mst_item");
        result.append(", itemId=");
        result.append(this.itemId);
        result.append(", itemName=");
        result.append(this.itemName);
        result.append(", unitPrice=");
        result.append(this.unitPrice);
        result.append(", costPrice=");
        result.append(this.costPrice);
        result.append(", stockAmount=");
        result.append(this.stockAmount);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + itemId.hashCode();
        result = prime * result + itemName.hashCode();
        result = prime * result + unitPrice.hashCode();
        result = prime * result + costPrice.hashCode();
        result = prime * result + stockAmount.hashCode();
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
        MstItem other = (MstItem) obj;
        if(this.itemId.equals(other.itemId) == false) {
            return false;
        }
        if(this.itemName.equals(other.itemName) == false) {
            return false;
        }
        if(this.unitPrice.equals(other.unitPrice) == false) {
            return false;
        }
        if(this.costPrice.equals(other.costPrice) == false) {
            return false;
        }
        if(this.stockAmount.equals(other.stockAmount) == false) {
            return false;
        }
        return true;
    }
    /**
     * 商品名を返す。
     * @return 商品名
     * @throws NullPointerException 商品名の値が<code>null</code>である場合
     */
    public String getItemNameAsString() {
        return this.itemName.getAsString();
    }
    /**
     * 商品名を設定する。
     * @param itemName0 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemNameAsString(String itemName0) {
        this.itemName.modify(itemName0);
    }
    @Override public void write(DataOutput out) throws IOException {
        itemId.write(out);
        itemName.write(out);
        unitPrice.write(out);
        costPrice.write(out);
        stockAmount.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        itemId.readFields(in);
        itemName.readFields(in);
        unitPrice.readFields(in);
        costPrice.readFields(in);
        stockAmount.readFields(in);
    }
}
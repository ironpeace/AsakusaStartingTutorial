package mufg.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.LongOption;
import com.asakusafw.runtime.value.StringOption;
import com.asakusafw.vocabulary.model.Joined;
import com.asakusafw.vocabulary.model.Key;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mufg.modelgen.dmdl.io.JoinedSalesItemInput;
import mufg.modelgen.dmdl.io.JoinedSalesItemOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * 売上伝票+商品マスタを表すデータモデルクラス。
 */
@DataModelKind("DMDL")@Joined(terms = {@Joined.Term(source = TrnSalesDetail.class, mappings = {@Joined.Mapping(source = 
                "salesDetailId", destination = "salesDetailId"),@Joined.Mapping(source = "amount", destination = 
                "amount"),@Joined.Mapping(source = "itemId", destination = "itemId")}, shuffle = @Key(group = {"itemId"}
            )),@Joined.Term(source = MstItem.class, mappings = {@Joined.Mapping(source = "itemId", destination = 
                "itemId"),@Joined.Mapping(source = "itemName", destination = "itemName")}, shuffle = @Key(group = {
                "itemId"}))})@ModelInputLocation(JoinedSalesItemInput.class)@ModelOutputLocation(JoinedSalesItemOutput.
        class)@PropertyOrder({"sales_detail_id", "amount", "item_id", "item_name"}) public class JoinedSalesItem 
        implements DataModel<JoinedSalesItem>, Writable {
    private final LongOption salesDetailId = new LongOption();
    private final LongOption amount = new LongOption();
    private final LongOption itemId = new LongOption();
    private final StringOption itemName = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.salesDetailId.setNull();
        this.amount.setNull();
        this.itemId.setNull();
        this.itemName.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(JoinedSalesItem other) {
        this.salesDetailId.copyFrom(other.salesDetailId);
        this.amount.copyFrom(other.amount);
        this.itemId.copyFrom(other.itemId);
        this.itemName.copyFrom(other.itemName);
    }
    /**
     * sales_detail_idを返す。
     * @return sales_detail_id
     * @throws NullPointerException sales_detail_idの値が<code>null</code>である場合
     */
    public long getSalesDetailId() {
        return this.salesDetailId.get();
    }
    /**
     * sales_detail_idを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setSalesDetailId(long value) {
        this.salesDetailId.modify(value);
    }
    /**
     * <code>null</code>を許すsales_detail_idを返す。
     * @return sales_detail_id
     */
    public LongOption getSalesDetailIdOption() {
        return this.salesDetailId;
    }
    /**
     * sales_detail_idを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setSalesDetailIdOption(LongOption option) {
        this.salesDetailId.copyFrom(option);
    }
    /**
     * amountを返す。
     * @return amount
     * @throws NullPointerException amountの値が<code>null</code>である場合
     */
    public long getAmount() {
        return this.amount.get();
    }
    /**
     * amountを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAmount(long value) {
        this.amount.modify(value);
    }
    /**
     * <code>null</code>を許すamountを返す。
     * @return amount
     */
    public LongOption getAmountOption() {
        return this.amount;
    }
    /**
     * amountを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAmountOption(LongOption option) {
        this.amount.copyFrom(option);
    }
    /**
     * item_idを返す。
     * @return item_id
     * @throws NullPointerException item_idの値が<code>null</code>である場合
     */
    public long getItemId() {
        return this.itemId.get();
    }
    /**
     * item_idを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemId(long value) {
        this.itemId.modify(value);
    }
    /**
     * <code>null</code>を許すitem_idを返す。
     * @return item_id
     */
    public LongOption getItemIdOption() {
        return this.itemId;
    }
    /**
     * item_idを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemIdOption(LongOption option) {
        this.itemId.copyFrom(option);
    }
    /**
     * item_nameを返す。
     * @return item_name
     * @throws NullPointerException item_nameの値が<code>null</code>である場合
     */
    public Text getItemName() {
        return this.itemName.get();
    }
    /**
     * item_nameを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemName(Text value) {
        this.itemName.modify(value);
    }
    /**
     * <code>null</code>を許すitem_nameを返す。
     * @return item_name
     */
    public StringOption getItemNameOption() {
        return this.itemName;
    }
    /**
     * item_nameを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemNameOption(StringOption option) {
        this.itemName.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=joined_sales_item");
        result.append(", salesDetailId=");
        result.append(this.salesDetailId);
        result.append(", amount=");
        result.append(this.amount);
        result.append(", itemId=");
        result.append(this.itemId);
        result.append(", itemName=");
        result.append(this.itemName);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + salesDetailId.hashCode();
        result = prime * result + amount.hashCode();
        result = prime * result + itemId.hashCode();
        result = prime * result + itemName.hashCode();
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
        JoinedSalesItem other = (JoinedSalesItem) obj;
        if(this.salesDetailId.equals(other.salesDetailId) == false) {
            return false;
        }
        if(this.amount.equals(other.amount) == false) {
            return false;
        }
        if(this.itemId.equals(other.itemId) == false) {
            return false;
        }
        if(this.itemName.equals(other.itemName) == false) {
            return false;
        }
        return true;
    }
    /**
     * item_nameを返す。
     * @return item_name
     * @throws NullPointerException item_nameの値が<code>null</code>である場合
     */
    public String getItemNameAsString() {
        return this.itemName.getAsString();
    }
    /**
     * item_nameを設定する。
     * @param itemName0 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemNameAsString(String itemName0) {
        this.itemName.modify(itemName0);
    }
    @Override public void write(DataOutput out) throws IOException {
        salesDetailId.write(out);
        amount.write(out);
        itemId.write(out);
        itemName.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        salesDetailId.readFields(in);
        amount.readFields(in);
        itemId.readFields(in);
        itemName.readFields(in);
    }
}
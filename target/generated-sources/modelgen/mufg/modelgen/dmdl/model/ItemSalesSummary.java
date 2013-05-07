package mufg.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.LongOption;
import com.asakusafw.runtime.value.StringOption;
import com.asakusafw.vocabulary.model.Key;
import com.asakusafw.vocabulary.model.Summarized;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mufg.modelgen.dmdl.io.ItemSalesSummaryInput;
import mufg.modelgen.dmdl.io.ItemSalesSummaryOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * 商品毎の販売数量を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(ItemSalesSummaryInput.class)@ModelOutputLocation(ItemSalesSummaryOutput.class)
        @PropertyOrder({"item_id", "item_name", "amount_total"})@Summarized(term = @Summarized.Term(source = 
        JoinedSalesItem.class, foldings = {@Summarized.Folding(aggregator = Summarized.Aggregator.ANY, source = "itemId"
            , destination = "itemId"),@Summarized.Folding(aggregator = Summarized.Aggregator.ANY, source = "itemName", 
            destination = "itemName"),@Summarized.Folding(aggregator = Summarized.Aggregator.SUM, source = "amount", 
            destination = "amountTotal")}, shuffle = @Key(group = {"itemId"}))) public class ItemSalesSummary implements 
        DataModel<ItemSalesSummary>, Writable {
    private final LongOption itemId = new LongOption();
    private final StringOption itemName = new StringOption();
    private final LongOption amountTotal = new LongOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.itemId.setNull();
        this.itemName.setNull();
        this.amountTotal.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(ItemSalesSummary other) {
        this.itemId.copyFrom(other.itemId);
        this.itemName.copyFrom(other.itemName);
        this.amountTotal.copyFrom(other.amountTotal);
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
    /**
     * amount_totalを返す。
     * @return amount_total
     * @throws NullPointerException amount_totalの値が<code>null</code>である場合
     */
    public long getAmountTotal() {
        return this.amountTotal.get();
    }
    /**
     * amount_totalを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAmountTotal(long value) {
        this.amountTotal.modify(value);
    }
    /**
     * <code>null</code>を許すamount_totalを返す。
     * @return amount_total
     */
    public LongOption getAmountTotalOption() {
        return this.amountTotal;
    }
    /**
     * amount_totalを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAmountTotalOption(LongOption option) {
        this.amountTotal.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=item_sales_summary");
        result.append(", itemId=");
        result.append(this.itemId);
        result.append(", itemName=");
        result.append(this.itemName);
        result.append(", amountTotal=");
        result.append(this.amountTotal);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + itemId.hashCode();
        result = prime * result + itemName.hashCode();
        result = prime * result + amountTotal.hashCode();
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
        ItemSalesSummary other = (ItemSalesSummary) obj;
        if(this.itemId.equals(other.itemId) == false) {
            return false;
        }
        if(this.itemName.equals(other.itemName) == false) {
            return false;
        }
        if(this.amountTotal.equals(other.amountTotal) == false) {
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
        itemId.write(out);
        itemName.write(out);
        amountTotal.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        itemId.readFields(in);
        itemName.readFields(in);
        amountTotal.readFields(in);
    }
}
package mufg.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import java.io.IOException;
import mufg.modelgen.dmdl.model.MstItem;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>mst_item</code>を読み出す
 */
public final class MstItemInput implements ModelInput<MstItem> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public MstItemInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(MstItem model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getItemIdOption());
        parser.fill(model.getItemNameOption());
        parser.fill(model.getUnitPriceOption());
        parser.fill(model.getCostPriceOption());
        parser.fill(model.getStockAmountOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}
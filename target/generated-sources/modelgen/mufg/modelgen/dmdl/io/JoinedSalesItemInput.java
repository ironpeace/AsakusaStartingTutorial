package mufg.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import java.io.IOException;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>joined_sales_item</code>を読み出す
 */
public final class JoinedSalesItemInput implements ModelInput<JoinedSalesItem> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public JoinedSalesItemInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(JoinedSalesItem model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getSalesDetailIdOption());
        parser.fill(model.getAmountOption());
        parser.fill(model.getItemIdOption());
        parser.fill(model.getItemNameOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}
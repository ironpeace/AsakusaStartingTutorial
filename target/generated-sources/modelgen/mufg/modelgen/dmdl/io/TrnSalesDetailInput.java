package mufg.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import java.io.IOException;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>trn_sales_detail</code>を読み出す
 */
public final class TrnSalesDetailInput implements ModelInput<TrnSalesDetail> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public TrnSalesDetailInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(TrnSalesDetail model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getSalesDetailIdOption());
        parser.fill(model.getSlipIdOption());
        parser.fill(model.getItemIdOption());
        parser.fill(model.getAmountOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}
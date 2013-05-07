package mufg.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import java.io.IOException;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
/**
 * <code>joined_sales_item</code>をTSVなどのレコード形式で出力する。
 */
public final class JoinedSalesItemOutput implements ModelOutput<JoinedSalesItem> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public JoinedSalesItemOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(JoinedSalesItem model) throws IOException {
        emitter.emit(model.getSalesDetailIdOption());
        emitter.emit(model.getAmountOption());
        emitter.emit(model.getItemIdOption());
        emitter.emit(model.getItemNameOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}
package mufg.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import java.io.IOException;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * <code>trn_sales_detail</code>をTSVなどのレコード形式で出力する。
 */
public final class TrnSalesDetailOutput implements ModelOutput<TrnSalesDetail> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public TrnSalesDetailOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(TrnSalesDetail model) throws IOException {
        emitter.emit(model.getSalesDetailIdOption());
        emitter.emit(model.getSlipIdOption());
        emitter.emit(model.getItemIdOption());
        emitter.emit(model.getAmountOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}
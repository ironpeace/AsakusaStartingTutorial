package mufg.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import java.io.IOException;
import mufg.modelgen.dmdl.model.MstItem;
/**
 * <code>mst_item</code>をTSVなどのレコード形式で出力する。
 */
public final class MstItemOutput implements ModelOutput<MstItem> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public MstItemOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(MstItem model) throws IOException {
        emitter.emit(model.getItemIdOption());
        emitter.emit(model.getItemNameOption());
        emitter.emit(model.getUnitPriceOption());
        emitter.emit(model.getCostPriceOption());
        emitter.emit(model.getStockAmountOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}
package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.Rendezvous;
import com.asakusafw.runtime.flow.RuntimeResourceManager;
import com.asakusafw.runtime.flow.SegmentedReducer;
import com.asakusafw.runtime.flow.VoidResult;
import com.asakusafw.runtime.stage.output.StageOutputDriver;
import java.io.IOException;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
import org.apache.hadoop.io.NullWritable;
/**
 * ステージ1の処理を担当するレデュースプログラム。
 */
@SuppressWarnings("deprecation") public final class StageReducer extends SegmentedReducer<ShuffleKey, ShuffleValue, 
        NullWritable, NullWritable> {
    private RuntimeResourceManager runtimeResourceManager;
    private StageOutputDriver outputs;
    private ReduceFragment3 rendezvous;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager = new RuntimeResourceManager(context.getConfiguration());
        this.runtimeResourceManager.setup();
        this.outputs = new StageOutputDriver(context);
        final Result<JoinedSalesItem> output = outputs.getResultSink("result0");
        this.rendezvous = new ReduceFragment3(output, new VoidResult<TrnSalesDetail>());
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager.cleanup();
        this.runtimeResourceManager = null;
        this.outputs.close();
        this.outputs = null;
        this.rendezvous = null;
    }
    @Override protected Rendezvous<ShuffleValue> getRendezvous(ShuffleKey nextKey) {
        switch(nextKey.getSegmentId()) {
            case 1:
            case 2:
                return this.rendezvous;
            default:
                throw new AssertionError();
        }
    }
}
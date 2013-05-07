package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0001;
import com.asakusafw.runtime.flow.RuntimeResourceManager;
import java.io.IOException;
import mufg.modelgen.dmdl.model.MstItem;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * {@code [in->padding(pseud#1720854532){owner=FlowBlock&#64;2055000954}]}の処理を担当するマッププログラム。
 */
@SuppressWarnings("deprecation") public final class StageMapper2 extends Mapper<NullWritable, MstItem, ShuffleKey, 
        ShuffleValue> {
    private MstItem cache = new MstItem();
    private RuntimeResourceManager runtimeResourceManager;
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager = new RuntimeResourceManager(context.getConfiguration());
        this.runtimeResourceManager.setup();
        final MapOutputFragment1 shuffle = new MapOutputFragment1(context);
        this.line = new MapFragment2(shuffle);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager.cleanup();
        this.runtimeResourceManager = null;
        this.line = null;
    }
    @Override public void run(Context context) throws IOException, InterruptedException {
        this.setup(context);
        while(context.nextKeyValue()) {
            cache.copyFrom(context.getCurrentValue());
            this.line.add(cache);
        }
        this.cleanup(context);
    }
}
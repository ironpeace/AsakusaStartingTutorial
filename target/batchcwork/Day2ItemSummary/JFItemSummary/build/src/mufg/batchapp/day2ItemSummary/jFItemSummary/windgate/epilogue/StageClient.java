package mufg.batchapp.day2ItemSummary.jFItemSummary.windgate.epilogue;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.collector.SortableSlot;
import com.asakusafw.runtime.stage.collector.WritableSlot;
import com.asakusafw.runtime.stage.input.TemporaryInputFormat;
import com.asakusafw.runtime.stage.output.TemporaryOutputFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mufg.batchapp.day2ItemSummary.jFItemSummary.windgate.epilogue.itemSalesSummary.StageMapper0;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
import org.apache.hadoop.io.NullWritable;
/**
 * "windgate"のエピローグステージのジョブを実行するクライアント。
 */
public final class StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "Day2ItemSummary";
    }
    @Override protected String getFlowId() {
        return "JFItemSummary";
    }
    @Override protected String getStageId() {
        return "epilogue.windgate";
    }
    @Override protected String getStageOutputPath() {
        return "target/hadoopwork/${execution_id}/Day2ItemSummary/JFItemSummary/epilogue/windgate";
    }
    @Override protected List<StageInput> getStageInputs() {
        List<StageInput> results = new ArrayList<StageInput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        results.add(new StageInput("target/hadoopwork/${execution_id}/Day2ItemSummary/JFItemSummary/stage0002/result0-*"
                , TemporaryInputFormat.class, StageMapper0.class, attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        results.add(new StageOutput("itemSalesSummary", NullWritable.class, ItemSalesSummary.class, 
                TemporaryOutputFormat.class));
        return results;
    }
    @Override protected Class<SortableSlot> getShuffleKeyClassOrNull() {
        return SortableSlot.class;
    }
    @Override protected Class<WritableSlot> getShuffleValueClassOrNull() {
        return WritableSlot.class;
    }
}
package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0002;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.StageResource;
import com.asakusafw.runtime.stage.input.TemporaryInputFormat;
import com.asakusafw.runtime.stage.output.TemporaryOutputFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
import org.apache.hadoop.io.NullWritable;
/**
 * ステージ2のジョブを実行するクライアント。
 */
public final class StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "Day2ItemSummary";
    }
    @Override protected String getFlowId() {
        return "JFItemSummary";
    }
    @Override protected String getStageId() {
        return "stage0002";
    }
    @Override protected String getStageOutputPath() {
        return "target/hadoopwork/${execution_id}/Day2ItemSummary/JFItemSummary/stage0002";
    }
    @Override protected List<StageInput> getStageInputs() {
        List<StageInput> results = new ArrayList<StageInput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        results.add(new StageInput("target/hadoopwork/${execution_id}/Day2ItemSummary/JFItemSummary/stage0001/result0-*"
                , TemporaryInputFormat.class, StageMapper1.class, attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        results.add(new StageOutput("result0", NullWritable.class, ItemSalesSummary.class, TemporaryOutputFormat.class))
                ;
        return results;
    }
    @Override protected List<StageResource> getStageResources() {
        List<StageResource> results = new ArrayList<StageResource>();
        return results;
    }
    @Override protected Class<ShuffleKey> getShuffleKeyClassOrNull() {
        return ShuffleKey.class;
    }
    @Override protected Class<ShuffleValue> getShuffleValueClassOrNull() {
        return ShuffleValue.class;
    }
    @Override protected Class<ShufflePartitioner> getPartitionerClassOrNull() {
        return ShufflePartitioner.class;
    }
    @Override protected Class<StageCombiner> getCombinerClassOrNull() {
        return StageCombiner.class;
    }
    @Override protected Class<ShuffleSortComparator> getSortComparatorClassOrNull() {
        return ShuffleSortComparator.class;
    }
    @Override protected Class<ShuffleGroupingComparator> getGroupingComparatorClassOrNull() {
        return ShuffleGroupingComparator.class;
    }
    @Override protected Class<StageReducer> getReducerClassOrNull() {
        return StageReducer.class;
    }
}
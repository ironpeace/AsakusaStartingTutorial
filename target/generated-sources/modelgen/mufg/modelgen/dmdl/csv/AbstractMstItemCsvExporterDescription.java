package mufg.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.windgate.FsExporterDescription;
import mufg.modelgen.dmdl.model.MstItem;
/**
 * An abstract implementation of {@link MstItem} exporter description using WindGate CSV.
 */
public abstract class AbstractMstItemCsvExporterDescription extends FsExporterDescription {
    @Override public Class<? extends MstItem> getModelType() {
        return MstItem.class;
    }
    @Override public Class<MstItemCsvSupport> getStreamSupport() {
        return MstItemCsvSupport.class;
    }
}
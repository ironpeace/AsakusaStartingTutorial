package mufg.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.windgate.FsImporterDescription;
import mufg.modelgen.dmdl.model.MstItem;
/**
 * An abstract implementation of {@link MstItem} importer description using WindGate CSV.
 */
public abstract class AbstractMstItemCsvImporterDescription extends FsImporterDescription {
    @Override public Class<? extends MstItem> getModelType() {
        return MstItem.class;
    }
    @Override public Class<MstItemCsvSupport> getStreamSupport() {
        return MstItemCsvSupport.class;
    }
}
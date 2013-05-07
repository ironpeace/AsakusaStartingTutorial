package mufg.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.windgate.FsImporterDescription;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
/**
 * An abstract implementation of {@link ItemSalesSummary} importer description using WindGate CSV.
 */
public abstract class AbstractItemSalesSummaryCsvImporterDescription extends FsImporterDescription {
    @Override public Class<? extends ItemSalesSummary> getModelType() {
        return ItemSalesSummary.class;
    }
    @Override public Class<ItemSalesSummaryCsvSupport> getStreamSupport() {
        return ItemSalesSummaryCsvSupport.class;
    }
}
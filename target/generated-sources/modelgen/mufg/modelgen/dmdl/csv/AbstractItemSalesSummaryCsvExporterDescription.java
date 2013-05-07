package mufg.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.windgate.FsExporterDescription;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
/**
 * An abstract implementation of {@link ItemSalesSummary} exporter description using WindGate CSV.
 */
public abstract class AbstractItemSalesSummaryCsvExporterDescription extends FsExporterDescription {
    @Override public Class<? extends ItemSalesSummary> getModelType() {
        return ItemSalesSummary.class;
    }
    @Override public Class<ItemSalesSummaryCsvSupport> getStreamSupport() {
        return ItemSalesSummaryCsvSupport.class;
    }
}
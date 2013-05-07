package mufg.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.windgate.FsImporterDescription;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * An abstract implementation of {@link TrnSalesDetail} importer description using WindGate CSV.
 */
public abstract class AbstractTrnSalesDetailCsvImporterDescription extends FsImporterDescription {
    @Override public Class<? extends TrnSalesDetail> getModelType() {
        return TrnSalesDetail.class;
    }
    @Override public Class<TrnSalesDetailCsvSupport> getStreamSupport() {
        return TrnSalesDetailCsvSupport.class;
    }
}
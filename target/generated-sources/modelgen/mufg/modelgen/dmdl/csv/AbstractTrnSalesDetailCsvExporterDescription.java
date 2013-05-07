package mufg.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.windgate.FsExporterDescription;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * An abstract implementation of {@link TrnSalesDetail} exporter description using WindGate CSV.
 */
public abstract class AbstractTrnSalesDetailCsvExporterDescription extends FsExporterDescription {
    @Override public Class<? extends TrnSalesDetail> getModelType() {
        return TrnSalesDetail.class;
    }
    @Override public Class<TrnSalesDetailCsvSupport> getStreamSupport() {
        return TrnSalesDetailCsvSupport.class;
    }
}
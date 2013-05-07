package mufg.modelgen.dmdl.csv;
import com.asakusafw.runtime.io.csv.CsvConfiguration;
import com.asakusafw.runtime.io.csv.CsvEmitter;
import com.asakusafw.runtime.io.csv.CsvParser;
import com.asakusafw.windgate.core.vocabulary.DataModelStreamSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * Supports CSV for {@link TrnSalesDetail}.
 */
public class TrnSalesDetailCsvSupport implements DataModelStreamSupport<TrnSalesDetail> {
    /**
     * Returns this CSV format configuration.
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration() {
        List<String> headers = new ArrayList<String>();
        headers.add("SALES_DETAIL_ID");
        headers.add("SLIP_ID");
        headers.add("ITEM_ID");
        headers.add("AMOUNT");
        return new CsvConfiguration(Charset.forName("UTF-8"), headers, "true", "false", "yyyy-MM-dd", 
                "yyyy-MM-dd HH:mm:ss");
    }
    @Override public Class<TrnSalesDetail> getSupportedType() {
        return TrnSalesDetail.class;
    }
    @Override public DataModelStreamSupport.DataModelReader<TrnSalesDetail> createReader(String path, InputStream stream
            ) throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvParser parser = new CsvParser(stream, path, this.getConfiguration());
        return new StreamReader(parser);
    }
    @Override public DataModelStreamSupport.DataModelWriter<TrnSalesDetail> createWriter(String path, OutputStream 
            stream) throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvEmitter emitter = new CsvEmitter(stream, path, this.getConfiguration());
        return new StreamWriter(emitter);
    }
    private static final class StreamReader implements DataModelStreamSupport.DataModelReader<TrnSalesDetail> {
        private final CsvParser parser;
        StreamReader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(TrnSalesDetail object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getSalesDetailIdOption());
            parser.fill(object.getSlipIdOption());
            parser.fill(object.getItemIdOption());
            parser.fill(object.getAmountOption());
            parser.endRecord();
            return true;
        }
    }
    private static final class StreamWriter implements DataModelStreamSupport.DataModelWriter<TrnSalesDetail> {
        private final CsvEmitter emitter;
        StreamWriter(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(TrnSalesDetail object) throws IOException {
            emitter.emit(object.getSalesDetailIdOption());
            emitter.emit(object.getSlipIdOption());
            emitter.emit(object.getItemIdOption());
            emitter.emit(object.getAmountOption());
            emitter.endRecord();
        }
        @Override public void flush() throws IOException {
            emitter.flush();
        }
    }
}
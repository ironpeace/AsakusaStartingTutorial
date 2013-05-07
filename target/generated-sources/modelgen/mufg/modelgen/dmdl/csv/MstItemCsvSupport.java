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
import mufg.modelgen.dmdl.model.MstItem;
/**
 * Supports CSV for {@link MstItem}.
 */
public class MstItemCsvSupport implements DataModelStreamSupport<MstItem> {
    /**
     * Returns this CSV format configuration.
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration() {
        List<String> headers = new ArrayList<String>();
        headers.add("ITEM_ID");
        headers.add("ITEM_NAME");
        headers.add("UNIT_PRICE");
        headers.add("COST_PRICE");
        headers.add("STOCK_AMOUNT");
        return new CsvConfiguration(Charset.forName("UTF-8"), headers, "true", "false", "yyyy-MM-dd", 
                "yyyy-MM-dd HH:mm:ss");
    }
    @Override public Class<MstItem> getSupportedType() {
        return MstItem.class;
    }
    @Override public DataModelStreamSupport.DataModelReader<MstItem> createReader(String path, InputStream stream) 
            throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvParser parser = new CsvParser(stream, path, this.getConfiguration());
        return new StreamReader(parser);
    }
    @Override public DataModelStreamSupport.DataModelWriter<MstItem> createWriter(String path, OutputStream stream) 
            throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvEmitter emitter = new CsvEmitter(stream, path, this.getConfiguration());
        return new StreamWriter(emitter);
    }
    private static final class StreamReader implements DataModelStreamSupport.DataModelReader<MstItem> {
        private final CsvParser parser;
        StreamReader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(MstItem object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getItemIdOption());
            parser.fill(object.getItemNameOption());
            parser.fill(object.getUnitPriceOption());
            parser.fill(object.getCostPriceOption());
            parser.fill(object.getStockAmountOption());
            parser.endRecord();
            return true;
        }
    }
    private static final class StreamWriter implements DataModelStreamSupport.DataModelWriter<MstItem> {
        private final CsvEmitter emitter;
        StreamWriter(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(MstItem object) throws IOException {
            emitter.emit(object.getItemIdOption());
            emitter.emit(object.getItemNameOption());
            emitter.emit(object.getUnitPriceOption());
            emitter.emit(object.getCostPriceOption());
            emitter.emit(object.getStockAmountOption());
            emitter.endRecord();
        }
        @Override public void flush() throws IOException {
            emitter.flush();
        }
    }
}
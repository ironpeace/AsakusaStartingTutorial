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
import mufg.modelgen.dmdl.model.ItemSalesSummary;
/**
 * Supports CSV for {@link ItemSalesSummary}.
 */
public class ItemSalesSummaryCsvSupport implements DataModelStreamSupport<ItemSalesSummary> {
    /**
     * Returns this CSV format configuration.
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration() {
        List<String> headers = new ArrayList<String>();
        headers.add("商品ID");
        headers.add("商品名");
        headers.add("販売数量");
        return new CsvConfiguration(Charset.forName("UTF-8"), headers, "true", "false", "yyyy-MM-dd", 
                "yyyy-MM-dd HH:mm:ss");
    }
    @Override public Class<ItemSalesSummary> getSupportedType() {
        return ItemSalesSummary.class;
    }
    @Override public DataModelStreamSupport.DataModelReader<ItemSalesSummary> createReader(String path, InputStream 
            stream) throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvParser parser = new CsvParser(stream, path, this.getConfiguration());
        return new StreamReader(parser);
    }
    @Override public DataModelStreamSupport.DataModelWriter<ItemSalesSummary> createWriter(String path, OutputStream 
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
    private static final class StreamReader implements DataModelStreamSupport.DataModelReader<ItemSalesSummary> {
        private final CsvParser parser;
        StreamReader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(ItemSalesSummary object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getItemIdOption());
            parser.fill(object.getItemNameOption());
            parser.fill(object.getAmountTotalOption());
            parser.endRecord();
            return true;
        }
    }
    private static final class StreamWriter implements DataModelStreamSupport.DataModelWriter<ItemSalesSummary> {
        private final CsvEmitter emitter;
        StreamWriter(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(ItemSalesSummary object) throws IOException {
            emitter.emit(object.getItemIdOption());
            emitter.emit(object.getItemNameOption());
            emitter.emit(object.getAmountTotalOption());
            emitter.endRecord();
        }
        @Override public void flush() throws IOException {
            emitter.flush();
        }
    }
}
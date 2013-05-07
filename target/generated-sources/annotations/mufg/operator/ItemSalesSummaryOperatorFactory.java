package mufg.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.flow.processor.PartialAggregation;
import com.asakusafw.vocabulary.operator.MasterJoin;
import com.asakusafw.vocabulary.operator.Summarize;
import java.util.Arrays;
import javax.annotation.Generated;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
import mufg.modelgen.dmdl.model.MstItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * {@link ItemSalesSummaryOperator}に関する演算子ファクトリークラス。
 * @see ItemSalesSummaryOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1") public class ItemSalesSummaryOperatorFactory {
    /**
     */
    public static final class SummarizeByCategory implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<ItemSalesSummary> out;
        SummarizeByCategory(Source<JoinedSalesItem> joinedSalesItem) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(Summarize.class);
            builder.declare(ItemSalesSummaryOperator.class, ItemSalesSummaryOperatorImpl.class, "summarizeByCategory");
            builder.declareParameter(JoinedSalesItem.class);
            builder.addInput("joinedSalesItem", joinedSalesItem, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), 
                    Arrays.asList(new ShuffleKey.Order[]{})));
            builder.addOutput("out", ItemSalesSummary.class);
            builder.addAttribute(FlowBoundary.SHUFFLE);
            builder.addAttribute(ObservationCount.DONT_CARE);
            builder.addAttribute(PartialAggregation.PARTIAL);
            this.$ = builder.toResolver();
            this.$.resolveInput("joinedSalesItem", joinedSalesItem);
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public ItemSalesSummaryOperatorFactory.SummarizeByCategory as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param joinedSalesItem
     * @return 生成した演算子オブジェクト
     * @see ItemSalesSummaryOperator#summarizeByCategory(JoinedSalesItem)
     */
    public ItemSalesSummaryOperatorFactory.SummarizeByCategory summarizeByCategory(Source<JoinedSalesItem> 
            joinedSalesItem) {
        return new ItemSalesSummaryOperatorFactory.SummarizeByCategory(joinedSalesItem);
    }
    /**
     */
    public static final class JoinItem implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<JoinedSalesItem> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<TrnSalesDetail> missed;
        JoinItem(Source<MstItem> mstItem, Source<TrnSalesDetail> trnSalesDetal) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterJoin.class);
            builder0.declare(ItemSalesSummaryOperator.class, ItemSalesSummaryOperatorImpl.class, "joinItem");
            builder0.declareParameter(MstItem.class);
            builder0.declareParameter(TrnSalesDetail.class);
            builder0.addInput("mstItem", mstItem, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), Arrays.asList(
                    new ShuffleKey.Order[]{})));
            builder0.addInput("trnSalesDetal", trnSalesDetal, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), 
                    Arrays.asList(new ShuffleKey.Order[]{})));
            builder0.addOutput("joined", JoinedSalesItem.class);
            builder0.addOutput("missed", trnSalesDetal);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("mstItem", mstItem);
            this.$.resolveInput("trnSalesDetal", trnSalesDetal);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public ItemSalesSummaryOperatorFactory.JoinItem as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * @param mstItem
     * @param trnSalesDetal
     * @return 生成した演算子オブジェクト
     * @see ItemSalesSummaryOperator#joinItem(MstItem, TrnSalesDetail)
     */
    public ItemSalesSummaryOperatorFactory.JoinItem joinItem(Source<MstItem> mstItem, Source<TrnSalesDetail> 
            trnSalesDetal) {
        return new ItemSalesSummaryOperatorFactory.JoinItem(mstItem, trnSalesDetal);
    }
}
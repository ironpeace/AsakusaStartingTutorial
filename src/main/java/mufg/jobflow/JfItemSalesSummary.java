package mufg.jobflow;

import mufg.modelgen.dmdl.model.ItemSalesSummary;
import mufg.modelgen.dmdl.model.MstItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
import mufg.operator.ItemSalesSummaryOperatorFactory;
import mufg.operator.ItemSalesSummaryOperatorFactory.JoinItem;
import mufg.operator.ItemSalesSummaryOperatorFactory.SummarizeByCategory;

import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;

/**
 * 商品別に販売数量の集計を行う。
 */
@JobFlow(name = "JFItemSummary") // ジョブフローID
public class JfItemSalesSummary extends FlowDescription {
    final In<MstItem> mstItem;
    final In<TrnSalesDetail> trnSalesDetail;
    final Out<ItemSalesSummary> itemSalesSummary;
 
    public JfItemSalesSummary(
            // 入力データの定義
            @Import(name = "MstItem", description = MstItemFromCsv.class)
            In<MstItem> mstItem,
            @Import(name = "TrnSalesDetail", description = TrnSalesDetailFromCsv.class)
            In<TrnSalesDetail> trnSalesDetail,
            // 出力データの定義
            @Export(name = "ItemSalesSummary", description = ItemSalesSummaryToCsv.class)
            Out<ItemSalesSummary> itemSalesSummary) {
    	this.mstItem= mstItem;
        this.trnSalesDetail= trnSalesDetail;
        this.itemSalesSummary = itemSalesSummary;
    }
 
    @Override
    protected void describe() {
        ItemSalesSummaryOperatorFactory operators = new ItemSalesSummaryOperatorFactory(); // 作成したOperatorのFactoryクラスをインスタンス化して使用
        CoreOperatorFactory core = new CoreOperatorFactory(); // AsakusaFWに用意されているコア演算子を使用する場合
 
        // 売上伝票明細と商品マスタをジョインする
        JoinItem joinItem = operators.joinItem(mstItem, trnSalesDetail);
        // ジョインできなかったレコードは捨てる
        core.stop(joinItem.missed); // 不要な出力は、stop演算子で止める（stopはコア演算子）
 
        // 売上をカテゴリ別に集計
        // 結合演算子の結合結果joinItemを単純集計演算子summarizeByItemのパラメタに引き渡す
        //SummarizeByItem summarize = operators.summarizeByItem(joinItem.joined);
        SummarizeByCategory summarize = operators.summarizeByCategory(joinItem.joined);
 
        // 集計結果を出力
        itemSalesSummary.add(summarize.out);// 単純集計演算子の出力をこのジョブの出力にadd
    }}

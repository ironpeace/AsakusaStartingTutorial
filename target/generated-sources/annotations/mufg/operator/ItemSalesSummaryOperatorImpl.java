package mufg.operator;
import javax.annotation.Generated;
import mufg.modelgen.dmdl.model.ItemSalesSummary;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
import mufg.modelgen.dmdl.model.MstItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
/**
 * {@link ItemSalesSummaryOperator}に関する演算子実装クラス。
 */
@Generated("OperatorImplementationClassGenerator:0.0.1") public class ItemSalesSummaryOperatorImpl extends 
        ItemSalesSummaryOperator {
    /**
     * インスタンスを生成する。
     */
    public ItemSalesSummaryOperatorImpl() {
        return;
    }
    @Override public ItemSalesSummary summarizeByCategory(JoinedSalesItem joinedSalesItem) {
        throw new UnsupportedOperationException("単純集計演算子は組み込みの方法で処理されます");
    }
    @Override public JoinedSalesItem joinItem(MstItem mstItem, TrnSalesDetail trnSalesDetal) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
}
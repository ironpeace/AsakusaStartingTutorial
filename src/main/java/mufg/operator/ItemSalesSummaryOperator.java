package mufg.operator;

import mufg.modelgen.dmdl.model.ItemSalesSummary;
import mufg.modelgen.dmdl.model.JoinedSalesItem;
import mufg.modelgen.dmdl.model.MstItem;
import mufg.modelgen.dmdl.model.TrnSalesDetail;
import com.asakusafw.vocabulary.operator.MasterJoin;
import com.asakusafw.vocabulary.operator.Summarize;

public abstract class ItemSalesSummaryOperator {
	@MasterJoin()
	public abstract JoinedSalesItem joinItem(MstItem mstItem, TrnSalesDetail trnSalesDetal);

	@Summarize
	public abstract ItemSalesSummary summarizeByCategory(JoinedSalesItem joinedSalesItem);
}

このチュートリアルは、こちらの記事のものを詳細化したものです。
図等はこちらの記事を参考にしてください。
http://www.atmarkit.co.jp/fjava/rensai4/bigdata_java07/03.html
尚、分析対象データは、dataディレクトリ配下にあります。

環境構築は事前に済ましている前提です。
環境構築手順については、こちらをご参照。
http://asakusafw.s3.amazonaws.com/documents/jinrikisha/ja/html/install.html


1. プロジェクト作成

	1) cd  workspace/

	2) mvn archetype:generate -DarchetypeCatalog=http://asakusafw.s3.amazonaws.com/maven/archetype-catalog-0.5.xml
	
	以下出力結果が得られます。

		Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
		[INFO] Scanning for projects...
		[INFO]                                                                         
		[INFO] ------------------------------------------------------------------------
		[INFO] Building Maven Stub Project (No POM) 1
		[INFO] ------------------------------------------------------------------------
		[INFO] 
		[INFO] >>> maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom >>>
		[INFO] 
		[INFO] <<< maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom <<<
		[INFO] 
		[INFO] --- maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom ---
		[INFO] Generating project in Interactive mode
		[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
		Choose archetype:
		1: http://asakusafw.s3.amazonaws.com/maven/archetype-catalog-0.5.xml -> com.asakusafw:asakusa-archetype-windgate (-)
		2: http://asakusafw.s3.amazonaws.com/maven/archetype-catalog-0.5.xml -> com.asakusafw:asakusa-archetype-thundergate (-)
		3: http://asakusafw.s3.amazonaws.com/maven/archetype-catalog-0.5.xml -> com.asakusafw:asakusa-archetype-directio (-)
		Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 

	3) 1を入力
	
	以下出力結果が得られます。

		Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
		Choose com.asakusafw:asakusa-archetype-windgate version: 
		1: 0.5-SNAPSHOT
		2: 0.5.0
		Choose a number: 2: 

	4) そのままEnter
	
	以下出力結果が得られます。

		Define value for property 'groupId': : 

	5) mufg と入力
	
	以下出力結果が得られます。

		Define value for property 'artifactId': : 

	6) tutorial と入力
	
	以下出力結果が得られます。

		Define value for property 'version':  1.0-SNAPSHOT: : 

	7) そのままEnter
	
	以下出力結果が得られます。

		Define value for property 'package':  mufg: :         

	8) そのままEnter
	
	以下出力結果が得られます。

		Confirm properties configuration:
		groupId: mufg
		artifactId: tutorial
		version: 1.0-SNAPSHOT
		package: mufg
		 Y: : 

	9) Y と入力
	
	以下出力結果が得られます。

		[INFO] ----------------------------------------------------------------------------
		[INFO] Using following parameters for creating project from Archetype: asakusa-archetype-windgate:0.4.0
		[INFO] ----------------------------------------------------------------------------
		[INFO] Parameter: groupId, Value: mufg
		[INFO] Parameter: artifactId, Value: tutorial
		[INFO] Parameter: version, Value: 1.0-SNAPSHOT
		[INFO] Parameter: package, Value: mufg
		[INFO] Parameter: packageInPathFormat, Value: mufg
		[INFO] Parameter: package, Value: mufg
		[INFO] Parameter: version, Value: 1.0-SNAPSHOT
		[INFO] Parameter: groupId, Value: mufg
		[INFO] Parameter: artifactId, Value: tutorial
		[INFO] project created from Archetype in dir: /Users/ITPUser/dev/asakusa/asakusa-develop/workspace/tutorial
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time: 3:02.870s
		[INFO] Finished at: Thu May 02 16:14:31 JST 2013
		[INFO] Final Memory: 8M/81M
		[INFO] ------------------------------------------------------------------------


2. eclipse対応

	1) cd tutorial

	2) mvn eclipse:eclipse
	
	以下出力結果が得られます。

		Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
		[INFO] Scanning for projects...
		[INFO]                                                                         
		[INFO] ------------------------------------------------------------------------
		[INFO] Building Batch Application Template (change it.) 1.0-SNAPSHOT
		[INFO] ------------------------------------------------------------------------
		[INFO] 

		（略）

		[INFO] 
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time: 14.198s
		[INFO] Finished at: Thu May 02 16:18:32 JST 2013
		[INFO] Final Memory: 10M/81M
		[INFO] ------------------------------------------------------------------------


	3) eclipse起動

	4) [File] > [Import...] > [General] > [Existing Projects into Workspace] > [Next] 

	5) workspace/tutorial ディレクトリを選択

	6) [Finish]

	7) Package Explorer で tutorial プロジェクトを選択して、右クリック

	8) [Properties] > [Text File Encoding] > [Other] > [UTF-8] > [Apply] > [Ok]


3. 入力データモデルの定義

	1) eclipseで、　tutorial/src/main/dmdl/models.dmdl を開く

	2) 以下で上書き

		"商品マスタ"
		@windgate.csv(has_header = TRUE)
		mst_item = {
		  "商品ID"
		   @windgate.csv.field(name = "ITEM_ID")
		   item_id: LONG;
		 
		  "商品名"
		   @windgate.csv.field(name = "ITEM_NAME")
		   item_name: TEXT;
		 
		  "商品単価"
		   @windgate.csv.field(name = "UNIT_PRICE")
		   unit_price: LONG;
		 
		  "商品原価"
		   @windgate.csv.field(name = "COST_PRICE")
		   cost_price: LONG;
		 
		  "在庫数量"
		   @windgate.csv.field(name = "STOCK_AMOUNT")
		   stock_amount: LONG;
		};
		 
		"売上明細"
		@windgate.csv(has_header = TRUE)
		trn_sales_detail = {
		  "売上明細ID"
		   @windgate.csv.field(name = "SALES_DETAIL_ID")
		   sales_detail_id: LONG;
		 
		  "伝票ID"
		   @windgate.csv.field(name = "SLIP_ID")
		   slip_id: LONG;
		 
		  "商品ID"
		   @windgate.csv.field(name = "ITEM_ID")
		   item_id: LONG;
		 
		  "数量"
		   @windgate.csv.field(name = "AMOUNT")
		   amount: LONG;
		};

4. 結合モデルの定義

	1) models.dmdl に以下を追記

		"売上伝票+商品マスタ"
		joined joined_sales_item = 
			trn_sales_detail -> {
				    sales_detail_id -> sales_detail_id;
				    amount -> amount;
				    item_id -> item_id;
				} % item_id 
			+ mst_item -> {
				    item_id -> item_id;
				    item_name ->  item_name;
				} % item_id;

		"商品毎の販売数量"
		@windgate.csv(has_header = TRUE)
		summarized item_sales_summary = joined_sales_item => {

		    @windgate.csv.field(name = "商品ID")
		    any item_id -> item_id ; // 表2の注1

		    @windgate.csv.field(name = "商品名")
		    any item_name -> item_name ; // 表2の注1

		    @windgate.csv.field(name = "販売数量")
		    sum amount -> amount_total; // 表2の注2

		} % item_id ; // グループ化キー（ここで指定した項目単位で集計を行う）


	2) eclipseで、tutorial/pom.xml を右クリックし、［Run As］>［Maven generate-source］
	
	以下出力結果が得られます。

		[INFO] Scanning for projects...
		[INFO]                                                                         
		[INFO] ------------------------------------------------------------------------
		[INFO] Building Batch Application Template (change it.) 1.0-SNAPSHOT
		[INFO] ------------------------------------------------------------------------
		[INFO] 

		(略)

		[INFO] Executed tasks
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time: 11.383s
		[INFO] Finished at: Thu May 02 16:51:15 JST 2013
		[INFO] Final Memory: 9M/81M
		[INFO] ------------------------------------------------------------------------


	3) eclipse で、 target/generated-sources/modelgen 配下を確認

	4) この時点でeclipseでエラーとなっているjavaファイルは全て削除

5. マスタ結合処理の実装

	1) eclipseで、src/main/java の、mufg.operator を右クリック

	2) [New] > [Class]

	3) Name に ItemSalesSummaryOperator と入力

	4) ソースに、以下を上書き

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

	5) eclipseで、tutorial/pom.xml を右クリックし、［Run As］>［Maven generate-source］
	
	以下出力結果が得られます。

		[INFO] Scanning for projects...
		[INFO]                                                                         
		[INFO] ------------------------------------------------------------------------
		[INFO] Building Batch Application Template (change it.) 1.0-SNAPSHOT
		[INFO] ------------------------------------------------------------------------
		[INFO] 

		(略)

		[INFO] Executed tasks
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time: 11.383s
		[INFO] Finished at: Thu May 02 16:51:15 JST 2013
		[INFO] Final Memory: 9M/81M
		[INFO] ------------------------------------------------------------------------


	6) eclipse で、 target/generated-sources/annotations 配下を確認

6. Expoerter/Importerの実装

	1) eclipseで、src/main/java の、mufg.jobflow を右クリック

	2) [New] > [Class]

	3) Name に MstItemFromCsv と入力

	4) ソースに、以下を上書き

		package mufg.jobflow;

		import mufg.modelgen.dmdl.csv.AbstractMstItemCsvImporterDescription;

		/**
		 * 商品マスタをWindGate/CSVからインポートする。
		 */
		public class MstItemFromCsv extends AbstractMstItemCsvImporterDescription {

		    @Override
		    public String getProfileName() {
		        return "asakusa";
		    }
		 
		    @Override
		    public String getPath() {
		        return "hands_on/input/mst_item.tsv";
		    }
		 
		    @Override
		    public DataSize getDataSize() {
		        return DataSize.LARGE;
		    }
		}

	5) eclipseで、src/main/java の、mufg.jobflow を右クリック

	6) [New] > [Class]

	7) Name に TrnSalesDetailFromCsv と入力

	8) ソースに、以下を上書き

		package mufg.jobflow;

		import mufg.modelgen.dmdl.csv.AbstractTrnSalesDetailCsvImporterDescription;

		/**
		 * 売上明細をWindGate/CSVからインポートする。
		 */
		public class TrnSalesDetailFromCsv extends
				AbstractTrnSalesDetailCsvImporterDescription {

			   @Override
			    public String getProfileName() {
			        return "asakusa";
			    }
			 
			    @Override
			    public String getPath() {
			        return "hands_on/input/trn_sales_detail.tsv";
			    }
			 
			    @Override
			    public DataSize getDataSize() {
			        return DataSize.LARGE;
			    }
		}


	9) eclipseで、src/main/java の、mufg.jobflow を右クリック

	10) [New] > [Class]

	11) Name に ItemSalesSummaryToCsv と入力

	12) ソースに、以下を上書き

		package mufg.jobflow;

		import mufg.modelgen.dmdl.csv.AbstractItemSalesSummaryCsvExporterDescription;

		/**
		 * 商品ごとの販売数量WindGate／CSVでエクスポート
		 */
		public class ItemSalesSummaryToCsv extends
				AbstractItemSalesSummaryCsvExporterDescription {

		    @Override
		    public String getProfileName() {
		        return "asakusa";
		    }

		    @Override
		    public String getPath() {
		        return "hands_on/output/item_sales_summary.csv";
		    }
		}

7. ジョブフローの実装

	1) eclipseで、src/main/java の、mufg.jobflow を右クリック

	2) [New] > [Class]

	3) Name に JfItemSalesSummary と入力

	4) ソースに、以下を上書き

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

8. バッチ処理の実装

	1) eclipseで、src/main/java の、mufg.batch を右クリック

	2) [New] > [Class]

	3) Name に BtSummarize と入力

	4) ソースに、以下を上書き

		package mufg.batch;

		import mufg.jobflow.JfItemSalesSummary;

		import com.asakusafw.vocabulary.batch.Batch;
		import com.asakusafw.vocabulary.batch.BatchDescription;

		@Batch(name = "Day2ItemSummary")
		public class BtSummarize extends BatchDescription {
		 
		    @Override
		    protected void describe() {
		        run(JfItemSalesSummary.class).soon();
		    }
		}


9. アプリケーションのビルド

	1) mvn clean package
	   (terminal)
	
	以下出力結果が得られます。

		Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
		[INFO] Scanning for projects...
		[INFO]                                                                         
		[INFO] ------------------------------------------------------------------------
		[INFO] Building Batch Application Template (change it.) 1.0-SNAPSHOT
		[INFO] ------------------------------------------------------------------------
		[INFO] 

		(略)		

		[INFO] Executed tasks
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time: 25.108s
		[INFO] Finished at: Thu May 02 18:10:30 JST 2013
		[INFO] Final Memory: 9M/81M
		[INFO] ------------------------------------------------------------------------


10. アプリケーションのデプロイ

	1) cp target/*batchapps*.jar $ASAKUSA_HOME/batchapps

	2) cd $ASAKUSA_HOME/batchapps

	3) 下記コマンドを実行してください。
	
		jar xf *batchapps*.jar

11. データの配置

	1) mkdir -p /tmp/windgate-$USER

	2) rm /tmp/windgate-$USER/* -rf

	3) mkdir /tmp/windgate-$USER/hands_on/

	3) mkdir /tmp/windgate-$USER/hands_on/input/

	4) cd /tmp/windgate-$USER/hands_on/input/
	
	5) wget https://raw.github.com/ironpeace/AsakusaStartingTutorial/master/data/mst_item.tsv

	6) wget https://raw.github.com/ironpeace/AsakusaStartingTutorial/master/data/trn_sales_detail.tsv


12. アプリケーションの実行

	1) $ASAKUSA_HOME/yaess/bin/yaess-batch.sh Day2ItemSummary
	
	以下出力結果が得られます。

		E/yaess/bin/yaess-batch.sh Day2ItemSummary
		Starting YAESS
		     Profile: /Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/conf/yaess.properties
		      Script: /Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/batchapps/Day2ItemSummary/etc/yaess-script.properties
		    Batch ID: Day2ItemSummary
		    Plug-ins: /Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/plugin/asakusa-yaess-flowlog-0.4.0.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/plugin/asakusa-yaess-jsch-0.4.0.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/plugin/asakusa-yaess-multidispatch-0.4.0.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/plugin/asakusa-yaess-paralleljob-0.4.0.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/plugin/jsch-0.1.48.jar
		   Classpath: /Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/conf:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/asakusa-yaess-bootstrap-0.4.0.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/asakusa-yaess-core-0.4.0.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/commons-cli-1.2.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/jul-to-slf4j-1.6.6.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/logback-classic-1.0.3.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/logback-core-1.0.3.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/yaess/lib/slf4j-api-1.6.6.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/core/lib/asakusa-runtime-all.jar:/Users/ITPUser/dev/asakusa/asakusa-develop/asakusa/core/lib/asakusa-thundergate-runtime.jar
		  Main Class: com.asakusafw.yaess.bootstrap.Yaess
		   Arguments: 
		  Properties: 
		2013/05/07 09:13:56 INFO  [YS-BOOTSTRAP-I00000] Starting YAESS

		(略)

		2013/05/07 09:14:19 INFO  [YS-BOOTSTRAP-I00999] Exiting YAESS: code=0, elapsed=23,041ms
		Finished: SUCCESS

	2) ls /tmp/windgate-$USER/hands_on/output/

	3) cat /tmp/windgate-$USER/hands_on/output/item_sales_summary.csv
	
	以下出力結果が得られます。

		商品ID,商品名,販売数量
		1,AAA,31
		2,BBB,28
		3,CCC,26



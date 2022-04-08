package chart;
  import java.awt.Font;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ScopeChart {
	ChartPanel frame1;
	public  ScopeChart(String type,String value,int more,int equal, int less){
		CategoryDataset dataset = getDataSet(more,equal,less,value);
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "Data Scope", // 图表标题
                            type+" distribution", // 目录轴的显示标签
                            "Number", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("Arial",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("Arial",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("Arial",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("Arial", Font.PLAIN, 15));
          chart.getTitle().setFont(new Font("Arial",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
	}
	
	public  ScopeChart(int num[]){
		CategoryDataset dataset = getDataSet(num);
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "Data for households with three device types", // 图表标题
                            " Data Category", // 目录轴的显示标签
                            "Data Number", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("Arial",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("Arial",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("Arial",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("Arial", Font.PLAIN, 15));
          chart.getTitle().setFont(new Font("Arial",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
	}
	
	private static CategoryDataset getDataSet(int more, int equal, int less,String value) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(more, "More than "+value, "More than "+value);
        dataset.addValue(equal, "Equal to "+value, "Equal to "+value);
        dataset.addValue(less, "less than "+value, "less than "+value);

        return dataset;
}
	
	private static CategoryDataset getDataSet(int num[]) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(num[0], "More than half", "Temperature");
        dataset.addValue(num[1], "Equal to half", "Temperature");
        dataset.addValue(num[2], "Less than half", "Temperature");
        dataset.addValue(num[3], "More than half", "Humidity");
        dataset.addValue(num[4], "Equal to half", "Humidity");
        dataset.addValue(num[5], "Less than half", "Humidity");
        dataset.addValue(num[6], "More than half", "Brightness");
        dataset.addValue(num[7], "Equal to half", "Brightness");
        dataset.addValue(num[8], "Less than half", "Brightness");
        dataset.addValue(num[9], "Open", "On/Off State");
        dataset.addValue(num[10], "Close", "On/Off State");


        return dataset;
}

public ChartPanel getChartPanel(){
	return frame1;
	
}

}
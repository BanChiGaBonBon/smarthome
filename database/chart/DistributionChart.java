package chart;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class DistributionChart {
	ChartPanel frame1;
	public DistributionChart(String type,float min,float max,int a,int b,int c,int d, int e){
		  DefaultPieDataset data = getDataSet(min,max,a,b,c,d,e);
	      JFreeChart chart = ChartFactory.createPieChart3D(type+" Distribution",data,true,false,false);
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("No Data");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("Arial",Font.BOLD,20));//设置标题字体
	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
	      piePlot.setLabelFont(new Font("Arial",Font.BOLD,10));//解决乱码
	      chart.getLegend().setItemFont(new Font("Arial",Font.PLAIN,10));
	}
	
	public DistributionChart(String type,int a,int b){
		  DefaultPieDataset data = getDataSet(a,b);
	      JFreeChart chart = ChartFactory.createPieChart3D(type+" Distribution",data,true,false,false);
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("No Data");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("Arial",Font.BOLD,20));//设置标题字体
	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
	      piePlot.setLabelFont(new Font("Arial",Font.BOLD,10));//解决乱码
	      chart.getLegend().setItemFont(new Font("Arial",Font.PLAIN,10));
	}
	
	
    private static DefaultPieDataset getDataSet(float min,float max,int v ,int w, int x, int y, int z) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        float a=(max-min)/5, b=min+(max-min)/5*2, c=min+(max-min)/5*3, d=min+(max-min)/5*4;
        dataset.setValue(min+"-"+a,v);
        dataset.setValue(a+"-"+b,w);
        dataset.setValue(b+"-"+c,x);
        dataset.setValue(c+"-"+d,y);
        dataset.setValue(d+"-"+max,z);
        return dataset;
}
    
    private static DefaultPieDataset getDataSet(int on,int off) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Open",on);
        dataset.setValue("Close",off);
        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }

    
}


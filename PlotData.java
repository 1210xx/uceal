package pub.rj.paper.plot;

import weka.core.*;
import java.io.FileReader;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class PlotData {
	
	public PlotData() {
		System.out.println("loading the PlotData");
	}
	
	public void drawScatterPlot() {
		
		long starTime = System.currentTimeMillis();
		XYSeries series = new XYSeries("xySeries");
		for (double x = -10; x < 10; x = x + 0.1) {
			double y = Math.sin(x);
			series.add(x, y);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createXYLineChart("y = sin(x)", // chart title
				"x", // x axis label
				"sin(x)", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, false, // include legend
				false, // tooltips
				false // urls
		);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, false); // 设置连线不可见
		plot.setRenderer(renderer);

		ChartFrame frame = new ChartFrame("my picture", chart);
		frame.pack(); // fit window to figure size
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		long endTime = System.currentTimeMillis();
		System.out.println("The draw Scatter plot time is: " + (endTime - starTime) + "ms");
		
	}

	public void drawGraph() {
		
		XYSeries series = new XYSeries("xySeries");
		for (int x = -100; x < 100; x++) {
			int y = x * x;
			series.add(x, y);
		}
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createXYLineChart("y = x^2", // chart title
				"x", // x axis label
				"x^2", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, false, // include legend
				false, // tooltips
				false // urls
		);
		
		ChartFrame frame = new ChartFrame("my picture", chart);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("the test line");
		PlotData pData = new PlotData();
		pData.drawScatterPlot();
		pData.drawGraph();
	}


}

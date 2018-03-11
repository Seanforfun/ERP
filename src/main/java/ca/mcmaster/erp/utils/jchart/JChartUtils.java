package ca.mcmaster.erp.utils.jchart;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 9, 2018 4:43:20 PM
 */
public class JChartUtils {
	public static void createChart(List<Object[]> dataList, OutputStream os) throws IOException{
		DefaultPieDataset dpds = new DefaultPieDataset();
		for(Object[] objs : dataList){
			dpds.setValue(objs[1].toString(), new Double(objs[0].toString()));
		}
		Font plotFont = new Font("ËÎÌå", Font.PLAIN, 16);  
		JFreeChart jfc = ChartFactory.createPieChart("Í³¼Æ±ý×´Í¼", dpds, true, true, false);
		TextTitle title = jfc.getTitle();
		title.setFont(plotFont);
		PiePlot plot = (PiePlot) jfc.getPlot();
		plot.setLabelFont(plotFont);
		LegendTitle legend = jfc.getLegend();
		legend.setItemFont(plotFont);
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.01D);
		
		BufferedImage bi = jfc.createBufferedImage(500, 400);
		ImageIO.write(bi, "png", os);
		os.flush();
	}
}

package ca.mcmaster.erp.util.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import ca.mcmaster.erp.auth.emp.model.EmpModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 29, 2018 1:23:02 PM
 */
public class GeneratorUtilsTest {
	private Class clazz;
	private String b;					//Emp
	private String s;					//emp
	private String pkg;				//ca.mcmaster.erp.auth.emp
	private String dir;				//ca/mcmaster/erp/auth/emp

	@Test
	public void demo1() throws Exception{
		GeneratorUtil(EmpModel.class);
	}
	private void GeneratorUtil(Class clazz) throws IOException {
		this.clazz = clazz;
		dataInit();
//		generatorDirectory();
//		generatorQueryModel();
		generatorHbmXml();
	}

	private void generatorHbmXml() throws IOException {
		File f = new File("src/main/java/" + dir + "/model/" + b + "Model.hbm.xml");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bw.newLine();
		bw.newLine();
		
		bw.write("<!DOCTYPE hibernate-mapping PUBLIC");
		bw.newLine();
		bw.write("        \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
		bw.newLine();
		bw.write("        \"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">");
		bw.newLine();
		bw.newLine();
		
		bw.write("        <hibernate-mapping>");
		bw.newLine();
		bw.write("        	<class name=\""+ pkg +".model."+ b +"Model\" table=\"tbl_"+ s +"Model\">");
		bw.newLine();
		bw.write("         		<id name=\"uuid\">");
		bw.newLine();
		bw.write("        			<generator class=\"native\"/>");
		bw.newLine();
		bw.write("        		</id>");
		bw.newLine();
		bw.newLine();
		
		Field[] declaredFields = clazz.getDeclaredFields();
		for(Field field : declaredFields){
			if(field.getModifiers() == Modifier.PRIVATE){
				if(!"uuid".equals(field.getName())){
					if(field.getType().equals(String.class) || 
							field.getType().equals(Integer.class)	||
							field.getType().equals(Double.class)	||
							field.getType().equals(Long.class)	){
						bw.write("        		<property name=\""+ field.getName() +"\" />");
						bw.newLine();
					}
				}
			}
		}
		
		bw.write("        	</class>");
		bw.newLine();
		bw.write("        </hibernate-mapping>");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
	
	private void generatorDirectory() {
		File ebi = new File("src/main/java/"+ dir +"/service/ebi");
		ebi.mkdirs();
		File ebo = new File("src/main/java/"+ dir +"/service/ebo");
		ebo.mkdirs();
		File web = new File("src/main/java/"+ dir +"/web");
		web.mkdirs();
		File dao = new File("src/main/java/"+ dir +"/dao/dao");
		dao.mkdirs();
		File impl = new File("src/main/java/"+ dir +"/dao/impl");
		impl.mkdirs();
	}

	private void generatorQueryModel() throws IOException {
		File f = new File("src/main/java/" + dir + "/model/" + b + "QueryModel.java");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write("package "+ pkg +".model;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import ca.mcmaster.erp.utils.base.BaseQueryModel;");
		bw.newLine();
		bw.newLine();
		
		bw.write("public class "+b+"QueryModel extends "+b+"Model implements BaseQueryModel{");
		bw.newLine();
		
		bw.write("	//TODO "+ b +"QueryModel");
		bw.newLine();
		
		bw.write("}");
		bw.flush();
		bw.close();
	}
	
	private void dataInit() {
		String className = clazz.getSimpleName();
		b = className.substring(0, (className.length() - 5));
		String first = b.substring(0, 1).toLowerCase();
		s = first + b.substring(1, b.length());
		String rootPkg = clazz.getPackage().getName();
		pkg = rootPkg.substring(0, rootPkg.lastIndexOf('.'));
		dir = pkg.replace('.', '/');
	}
}

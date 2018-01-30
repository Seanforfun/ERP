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
	private String l;					//e
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
//		generatorHbmXml();
//		generatorDao();
		generatorImpl();
//		generatorEbi();
//		generatorEbo();
//		generatorAction();
	}

	private void generatorAction() throws IOException {
		File f = new File("src/main/java/"+ dir + "/web/"+ b + "Action.java");
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".web;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import java.util.List;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import javax.annotation.Resource;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import "+pkg+".model."+b+"Model;");
		bw.newLine();
		bw.write("import "+pkg+".model."+b+"QueryModel;");
		bw.newLine();
		bw.write("import "+pkg+".service.ebi."+b+"Ebi;");
		bw.newLine();
		bw.write("import ca.mcmaster.erp.utils.base.BaseAction;");
		bw.newLine();
		bw.newLine();
		
		bw.write("@SuppressWarnings(\"serial\")");
		bw.newLine();
		bw.write("public class "+b+"Action extends BaseAction {");
		bw.newLine();
		bw.write("	public "+b+"Model "+l+"m = new "+b+"Model();");
		bw.newLine();
		bw.write("	public "+b+"QueryModel "+l+"qm = new "+b+"QueryModel(); ");
		bw.newLine();
		bw.write("	@Resource(name=\""+s+"Ebi\")");
		bw.newLine();
		bw.write("	private "+b+"Ebi "+s+"Ebi;");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public String list(){");
		bw.newLine();
		bw.write("		super.setDataTotal(dataTotal);");
		bw.newLine();
		bw.write("		List<"+b+"Model> "+s+"List = "+s+"Ebi.getAll("+l+"qm, pageNum, pageCount);");
		bw.newLine();
		bw.write("		super.put(\""+s+"List\", "+s+"List);");
		bw.newLine();
		bw.write("		return LIST;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public String input(){");
		bw.newLine();
		bw.write("		if("+l+"m.getUuid() != null){");
		bw.newLine();
		bw.write("			"+l+"m = "+s+"Ebi.get("+l+"m.getUuid());");
		bw.newLine();
		bw.write("		}");
		bw.newLine();
		bw.write("		return INPUT;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public String save(){");
		bw.newLine();
		bw.write("		if("+l+"m.getUuid() == null){");
		bw.newLine();
		bw.write("			"+s+"Ebi.save("+l+"m);");
		bw.newLine();
		bw.write("		}else{");
		bw.newLine();
		bw.write("			"+s+"Ebi.update("+l+"m);");
		bw.newLine();
		bw.write("		}");
		bw.newLine();
		bw.write("		return TO_LIST;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public String delete(){");
		bw.newLine();
		bw.write("		"+s+"Ebi.delete("+l+"m);");
		bw.newLine();
		bw.write("		return TO_LIST;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.write("}");

		bw.flush();
		bw.close();
	}
	
	private void generatorEbo() throws IOException {
		File f = new File("src/main/java/"+ dir + "/service/ebo/"+ b + "Ebo.java");
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".service.ebo;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import java.io.Serializable;");
		bw.newLine();
		bw.write("import java.util.List;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import javax.annotation.Resource;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import "+pkg+".dao.dao."+b+"Dao;");
		bw.newLine();
		bw.write("import "+pkg+".model."+b+"Model;");
		bw.newLine();
		bw.write("import "+pkg+".model."+b+"QueryModel;");
		bw.newLine();
		bw.write("import "+pkg+".service.ebi."+b+"Ebi;");
		bw.newLine();
		bw.write("import ca.mcmaster.erp.utils.base.BaseQueryModel;");
		bw.newLine();
		bw.newLine();
		
		bw.write("public class "+b+"Ebo implements "+b+"Ebi {");
		bw.newLine();
		bw.write("	@Resource(name=\""+s+"Dao\")");
		bw.newLine();
		bw.write("	private "+b+"Dao "+s+"Dao;");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public void save("+b+"Model "+l+"m) {");
		bw.newLine();
		bw.write("		"+s+"Dao.save("+l+"m);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public List<"+b+"Model> getAll() {");
		bw.newLine();
		bw.write("		List<"+b+"Model> "+s+"List = "+s+"Dao.getAll();");
		bw.newLine();
		bw.write("		return "+s+"List;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public "+b+"Model get(Serializable uuid) {");
		bw.newLine();
		bw.write("		"+b+"Model temp = "+s+"Dao.get(uuid);");
		bw.newLine();
		bw.write("		return temp;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public void update("+b+"Model "+l+"m) {");
		bw.newLine();
		bw.write("		"+s+"Dao.update("+l+"m);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public void delete("+b+"Model "+l+"m) {");
		bw.newLine();
		bw.write("		"+s+"Dao.delete("+l+"m);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public List<"+b+"Model> getAll("+b+"QueryModel "+l+"qm) {");
		bw.newLine();
		bw.write("		List<"+b+"Model> "+s+"List ="+s+"Dao.getAll("+l+"qm);");
		bw.newLine();
		bw.write("		return "+s+"List;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public List<"+b+"Model> getAll(BaseQueryModel bqm, Integer pageNum,");
		bw.newLine();
		bw.write("			Integer pageCount) {");
		bw.newLine();
		bw.write("		List<"+b+"Model> "+s+"List = "+s+"Dao.getAll(bqm, pageNum, pageCount);");
		bw.newLine();
		bw.write("		return "+s+"List;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public Integer getCount(BaseQueryModel bqm) {");
		bw.newLine();
		bw.write("		Integer count = "+s+"Dao.getCount(bqm);");
		bw.newLine();
		bw.write("		return count;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		
		bw.write("	public List<"+b+"Model> getAll(BaseQueryModel bqm) {");
		bw.newLine();
		bw.write("		return null;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
	
	private void generatorEbi() throws IOException {
		File f = new File("src/main/java/"+ dir + "/service/ebi/"+ b + "Ebi.java");
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".service.ebi;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import org.springframework.transaction.annotation.Transactional;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import "+pkg+".model."+b+"Model;");
		bw.newLine();
		bw.write("import ca.mcmaster.erp.utils.base.BaseEbi;");
		bw.newLine();
		bw.newLine();
		
		bw.write("@Transactional");
		bw.newLine();
		
		bw.write("public interface "+b+"Ebi extends BaseEbi<"+b+"Model> {");
		bw.newLine();
		bw.write("	//TODO EmpEbi");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
	
	private void generatorImpl() throws IOException {
		File f = new File("src/main/java/"+ dir + "/dao/impl/"+ b + "Impl.java");
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+ pkg +".dao.impl;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import org.hibernate.criterion.DetachedCriteria;");
		bw.newLine();
		bw.write("import org.hibernate.criterion.Restrictions;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import "+pkg+".dao.dao."+b+"Dao;");
		bw.newLine();
		bw.write("import "+pkg+".model."+b+"Model;");
		bw.newLine();
		bw.write("import "+pkg+".model."+b+"QueryModel;");
		bw.newLine();
		bw.write("import ca.mcmaster.erp.utils.base.BaseImpl;");
		bw.newLine();
		bw.write("import ca.mcmaster.erp.utils.base.BaseQueryModel;");
		bw.newLine();
		bw.newLine();
		
		bw.write("public class "+b+"Impl extends BaseImpl<"+b+"Model> implements "+b+"Dao {");
		bw.newLine();
		bw.newLine();
		bw.write("	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {");
		bw.newLine();
		bw.write("		"+b+"QueryModel "+l+"qm = ("+b+"QueryModel) bqm;");
		bw.newLine();
		bw.write("		//TODO doCriteria()");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
	private void generatorDao() throws IOException {
		File f = new File("src/main/java/"+ dir + "/dao/dao/"+ b + "Dao.java");
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+ pkg +".dao.dao;");
		bw.newLine();
		bw.newLine();
		
		bw.write("import " +pkg + ".model."+ b +"Model;");
		bw.newLine();
		bw.write("import ca.mcmaster.erp.utils.base.BaseDao;");
		bw.newLine();
		bw.newLine();
		
		bw.write("public interface "+b+"Dao extends BaseDao<"+b+"Model> {");
		bw.newLine();

		bw.write("	//TODO "+ b +"Dao");
		bw.newLine();
		bw.write("		"+b+"QueryModel dqm = ("+b+"QueryModel) bqm;");
		bw.newLine();
		bw.write("}");
		
		bw.flush();
		bw.close();
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
		l = b.substring(0, 1).toLowerCase();
		String first = b.substring(0, 1).toLowerCase();
		s = first + b.substring(1, b.length());
		String rootPkg = clazz.getPackage().getName();
		pkg = rootPkg.substring(0, rootPkg.lastIndexOf('.'));
		dir = pkg.replace('.', '/');
	}
}

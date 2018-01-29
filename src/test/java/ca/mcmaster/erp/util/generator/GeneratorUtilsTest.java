package ca.mcmaster.erp.util.generator;

import java.io.File;
import java.io.IOException;

import org.aspectj.apache.bcel.classfile.Field;
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
		generatorDirectory();
		generatorQueryModel();
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

	private void generatorQueryModel() {
		
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

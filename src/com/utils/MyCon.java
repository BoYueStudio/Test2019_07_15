package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.org.apache.xml.internal.security.Init;

public class MyCon {
private static DataSource ds=null;
private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

static {
	Init();
}
public static void Init(){
	Properties properties=new Properties();
	
	try {
		InputStream is=MyCon.class.getResourceAsStream("/jdbc.properties");
		properties.load(is);
		ds=BasicDataSourceFactory.createDataSource(properties);
	} catch (Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public Connection getCon(){
	Connection con=threadLocal.get();
	try {
		if(con==null || con.isClosed()){
			con=ds.getConnection();
			threadLocal.set(con);
			System.out.println("连接成功！");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
}
	
}

package com.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class App001 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;

		try {
			//Load a register Driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			//establish connection between Java and Database
			con	= DriverManager.getConnection("jdbc:odbc:syed", "system", "syed");
			
			//prepare Statement 
			st = con.createStatement();
			
			//Create BufferedReader for Dynamic input
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Table Name :");
			String table_Name = br.readLine();
			
			//prepare SQLQuery
			String  sql = "create table "+table_Name+"(eno number(3),ename varchar2(15),esal float,eaddr varchar(20))";
			
			//execute SQLQuery
			st.executeUpdate(sql);
			
			System.out.println("Table " + table_Name + "Created Successfully" );

		} catch (Exception e) {
			e.printStackTrace();
			}finally {
			try {
				
				//close All connection
				br.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}



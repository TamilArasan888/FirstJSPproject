package com.chainsys.jspproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chainsys.jspproject.pojo.Employee;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class EmployeeDao {
	/*
	 * getConnection() 
	 * insertEmployee(Employee newemp) 
	 * getEmployeeById(int id)
	 * getAllEmployees() 
	 * updateEmployee(Employee newemp)
	 *  deleteEmployee(int id)
	 */

	private static Connection getconnection() {
		Connection con = null;
		String drivername="oracle.jdbc.OracleDriver";
		String dburl="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="Jeffrey888";
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dburl,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int insertEmployee(Employee newemp) {
		String insertquery = "insert into employees(employee_id,first_name,last_name,email,hire_date,job_id,salary) values(?,?,?,?,?,?,?)";
		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = mycon.prepareStatement(insertquery);
			pstmt.setInt(1, newemp.getE_Id());
			pstmt.setString(2, newemp.getFirst_Name());
			pstmt.setString(3, newemp.getLast_Name());
			pstmt.setString(4, newemp.getEmail());
			pstmt.setDate(5, utiltoSqlConvert(newemp.getHire_Date()));
			pstmt.setString(6, newemp.getJob_ID());
			pstmt.setFloat(7, newemp.getSalary());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public static Employee getEmployeeById(int id) {
		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp=null;
		try {
			pstmt = mycon.prepareStatement("select employee_id,first_name,last_name,email,hire_date,job_id,salary from employees where employee_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			emp=new Employee();
			if(rs.next()) {
				emp.setE_Id(rs.getInt(1));
				emp.setFirst_Name(rs.getString(2));
				emp.setLast_Name(rs.getString(3));
				emp.setEmail(rs.getString(4));
				//
				emp.setHire_Date(sqltoUtilconvert(rs.getDate(5)));
				emp.setJob_ID(rs.getString(6));
				emp.setSalary(rs.getFloat(7));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	public static java.sql.Date utiltoSqlConvert(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	public static java.util.Date sqltoUtilconvert(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}

	public static List<Employee> getAllEmployees() {
		List<Employee>listOfEmployee =new ArrayList<Employee>();
		Connection mycon = getconnection();
		Statement stmt = null;
		ResultSet rs = null;
		Employee emp;
		try {
			stmt = mycon.createStatement();
			rs = stmt.executeQuery("select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY from employees");
			while(rs.next()) {
				emp=new Employee();
				emp.setE_Id(rs.getInt(1));
				emp.setFirst_Name(rs.getString(2));
				emp.setLast_Name(rs.getString(3));
				emp.setEmail(rs.getString(4));
//				
				emp.setHire_Date(sqltoUtilconvert(rs.getDate(5)));
				emp.setJob_ID(rs.getString(6));
				emp.setSalary(rs.getFloat(7));
				listOfEmployee.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfEmployee;
	}

	public static int updateEmployee(Employee newemp) {

		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = mycon.prepareStatement("update employees set first_name=?,last_name=?,email=?,hire_date=?,job_id=?,salary=? where employee_id=?");
			pstmt.setString(1, newemp.getFirst_Name());
			pstmt.setString(2, newemp.getLast_Name());
			pstmt.setString(3, newemp.getEmail());
			pstmt.setDate(4, utiltoSqlConvert(newemp.getHire_Date()));
			pstmt.setString(5, newemp.getJob_ID());
			pstmt.setFloat(6, newemp.getSalary());
			pstmt.setInt(7, newemp.getE_Id());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public static int deleteEmployee(int id) {
		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = mycon.prepareStatement("delete employees where employee_id=?");
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public  static int updateEmployeeFirstName(int id,String fname) {
		String updatequery = "update employees set FIRST_NAME=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try {
			con = getconnection();
			ps = con.prepareStatement(updatequery);
			ps.setString(1, fname);
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rows;
	}
	public  static int updateEmployeeSalary(int id, float salary) {
		String updatequery = "update employees set SALARY=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try {
			con = getconnection();
			ps = con.prepareStatement(updatequery);
			ps.setDouble(1, salary );
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
	
}
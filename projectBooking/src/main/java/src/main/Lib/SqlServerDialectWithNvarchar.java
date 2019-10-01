package src.main.Lib;

import java.sql.Types;

public class SqlServerDialectWithNvarchar extends org.hibernate.dialect.SQLServerDialect {

//    public SqlServerDialectWithNvarchar() {
//        registerHibernateType(Types.NVARCHAR, 4000, "string");
//    }
    
    public SqlServerDialectWithNvarchar() {
    	  super();
    	   
    	  registerColumnType(Types.VARCHAR, "nvarchar($l)");
    	  registerColumnType(Types.BIGINT, "bigint");
    	  registerColumnType(Types.BIT, "bit");
    	 }

}
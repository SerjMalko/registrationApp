1. Settings mySql driver for Wildfly:

- Enter in the file path ${EAP_HOME} and create the directories com/mysql/driver/main.

 Into the folder main copy the driver library jar and create a file module.xml as showed in the sample below
 
 <module xmlns="urn:jboss:module:1.3" name="com.mysql.driver">
 <resources>
  <resource-root path="mysql-connector-java-5.1.33.jar" />
 </resources>
 <dependencies>
  <module name="javax.api"/>
  <module name="javax.transaction.api"/>
 </dependencies>
</module>

- Enter to standalone.xml

	- add to  <drivers>
	
	<driver name="jdbcMySQLDriver" module="com.mysql.driver">
        <xa-datasource-class>com.mysql.jdbc.Driver</xa-datasource-class>
    </driver>
	
	- add to <datasource>
	
	<datasource jta="true" jndi-name="java:/RegTestDS" pool-name="RegTestDS" enabled="true" use-ccm="true">
		<connection-url>jdbc:mysql://localhost:3307/reg_test_db</connection-url>
        <driver-class>com.mysql.jdbc.Driver</driver-class>
        <driver>jdbcMySQLDriver</driver>
			<security>
				<user-name>root</user-name>
                <password>root</password>
            </security>
            <validation>
				<valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                <background-validation>true</background-validation>
                <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
            </validation>
	</datasource>
	
	
2. Mail settings on Wildfly

- Enter to standalone.xml

	- add to <subsystem xmlns="urn:jboss:domain:mail:2.0">
	
	<mail-session name="java:jboss/mail/gmail" debug="true" jndi-name="java:jboss/mail/gmail">
        <smtp-server outbound-socket-binding-ref="mail-smtp" ssl="true" username="testjavasm@gmail.com" password="2wsxZAQ!"/>
    </mail-session>
	
	
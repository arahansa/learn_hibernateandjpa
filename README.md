# learn_hibernateandjpa
하이버네이트 공부했던 자료들 엮음.. 웹에 있는 자료들이니, 일단은 올려두지만 저작권문제있으면 연락주세요.닫아놓겠습니다. 


혹시라도 h2 Db를 바꾸실 일이 있으시면...
hibernate.cfg.xml 파일을 다음과 같이 바꿔주세요
```
<property name="connection.driver_class">org.h2.Driver</property>
        <property name="connection.url">jdbc:h2:tcp://localhost/~/test;MVCC=true</property>
        <!--
        <property name="connection.url">jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE</property>
        -->
        <property name="connection.username">sa</property>
        <property name="connection.password"/> 
<!-- SQL dialect -->
<property name="dialect">org.hibernate.dialect.H2Dialect</property>
```



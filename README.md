Requirements
==================
- Jboss AS >=7.1.3
- Activiti >= 5.12
- JDK >=1.7

Jboss 7 JMS queue configuration
==================

<jms-destinations>
	<jms-queue name="Queue">
		<entry name="java:/queue/Queue"/>
	</jms-queue>
</jms-destinations>

PostgreSQL database configuration
==================

configuration/standalone-full-ha.xml  contains PostgreSQL db configuration section.
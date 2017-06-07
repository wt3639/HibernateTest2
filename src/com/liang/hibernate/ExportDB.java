package com.liang.hibernate;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 将hbm生成ddl
 * 
 * @author liang
 * 
 */
public class ExportDB {
	public static void main(String[] args) {
		// 默认读取hibernate.cfg.xml文件
		//Configuration cfg = new Configuration().configure();
		//// 生成并输出sql到文件（当前目录）和数据库
		ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure().build();  
		MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
		export.create(true, true);
		//SchemaExport export = new SchemaExport(cfg);
		//export.create(true, true);
	}
}
//package com.johnbenign.AirlineReservation.filter;
//
//import org.hibernate.boot.model.relational.Namespace;
//import org.hibernate.boot.model.relational.Sequence;
//import org.hibernate.mapping.Table;
//import org.hibernate.tool.schema.spi.SchemaFilter;
//
//public class CustomFilter implements SchemaFilter
//{
//	
//	public static final CustomFilter INSTANCE = new CustomFilter();
//	
//	@Override
//	public boolean includeNamespace(Namespace namespace)
//	{
//		return true;
//	}
//
//	@Override
//	public boolean includeTable(Table table)
//	{
//		return !table.getName().contains("UserDTO");
//	}
//
//	@Override
//	public boolean includeSequence(Sequence sequence)
//	{
//		return true;
//	}
//
//}

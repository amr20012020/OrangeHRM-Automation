package com.amr.config;
import java.util.Properties; import java.io.InputStream;
public final class ConfigReader { private static final Properties p=new Properties(); static {try(InputStream in=ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")){if(in==null)throw new IllegalStateException("Missing config.properties");p.load(in);}catch(Exception e){throw new ExceptionInInitializerError(e);}} private ConfigReader(){} public static String get(String key){String v=p.getProperty(key);if(v==null)throw new IllegalArgumentException(key);return v;}}

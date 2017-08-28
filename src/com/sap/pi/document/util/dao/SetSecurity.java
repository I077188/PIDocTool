package com.sap.pi.document.util.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import com.sap.engine.services.webservices.espbase.client.api.HTTPControlFactory;
import com.sap.engine.services.webservices.espbase.client.api.HTTPControlInterface;

public class SetSecurity {

	private String host;
	private String user;
	private String password;
	private String proxy_host;
	private String proxy_port;
	private String proxy_user;
	private String proxy_password;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProxy_host() {
		return proxy_host;
	}

	public void setProxy_host(String proxy_host) {
		this.proxy_host = proxy_host;
	}

	public String getProxy_user() {
		return proxy_user;
	}

	public void setProxy_user(String proxy_user) {
		this.proxy_user = proxy_user;
	}

	public String getProxy_port() {
		return proxy_port;
	}

	public void setProxy_port(String proxy_port) {
		this.proxy_port = proxy_port;
	}

	public String getProxy_password() {
		return proxy_password;
	}

	public void setProxy_password(String proxy_password) {
		this.proxy_password = proxy_password;
	}

	public void set_security(BindingProvider port, String url_path) throws IOException {
		BindingProvider bp = port;

		read_properties();
		Map<String, Object> context = bp.getRequestContext();
		context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host + url_path);
		context.put(BindingProvider.USERNAME_PROPERTY, user);
		context.put(BindingProvider.PASSWORD_PROPERTY, password);
		if (proxy_host == null || proxy_host.length() == 0) {
			return;
		}
		HTTPControlInterface httpControl = HTTPControlFactory.getInterface(port);
		httpControl.setHTTPProxy(proxy_host, Integer.parseInt(proxy_port));
		httpControl.setHTTPProxyUserPass(proxy_user, proxy_password);
	}

	public void read_properties() throws IOException {
		FileInputStream in = new FileInputStream(
				CONSTAINTS.resourcePath + File.separator + "config" + File.separator + "Configuration.properties");
		Properties prop = new Properties();
		prop.load(in);
		host = prop.getProperty("host");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		proxy_host = prop.getProperty("proxy_host");
		proxy_port = prop.getProperty("proxy_port");
		proxy_user = prop.getProperty("proxy_user");

	}
}

/**
 * ============================================================================
 * ============ COPYRIGHT NOTICE
 * ================================================
 * ======================================== Copyright (C) 2014, HCL Technologies
 * Limited. All Rights Reserved. Proprietary and confidential. All information
 * contained herein is, and remains the property of HCL Technologies Limited.
 * Copying or reproducing the contents of this file, via any medium is strictly
 * prohibited unless prior written permission is obtained from HCL Technologies
 * Limited.
 */

package util;

import static util.SampleTestConstants.COUNTRY_CODE;
import static util.SampleTestConstants.LANGUAGE_CODE;
import static util.SampleTestConstants.SECURITY_TOKEN_END_SERVICE_URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Builder;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.springframework.context.ApplicationContext;

import com.hcl.hmtp.common.client.exceptions.HMTPException;
import com.hcl.hmtp.common.server.ApplicationContextLoader;
import com.hcl.hmtp.common.server.PersistenceSessionManager;
import com.hcl.hmtp.common.server.ThreadSession;
import com.hcl.hmtp.common.server.ThreadSessionManager;
import com.hcl.hmtp.common.server.exceptions.ThreadSessionException;

/**
 * Utility class holds commonly used test fragments across the Microservice
 * 
 */
public class SampleIntegrationTestCasesUtil {

	private static final String USER_NAME = "j_username";
	private static final String PASS_WORD = "j_password";
	private static final String DOMAIN = "org";
	private static final String QUERY_PARAMETERS = "queryParameters";
	private static final String EQUALS = "=";
	private static final String AND = "&";
	public static final String LATN = "Latn";
	

	/**
	 * initializes the PAS Application context holder which would be used to
	 * retrieve the configured spring beans from application context.
	 * 
	 * @param applicationContext
	 */
	public static void initializePASContextHolder(
			final ApplicationContext applicationContext) {
		ApplicationContextLoader.setApplicationContext(applicationContext);
	}

	/**
	 * initializes PAS Thread session which would be used to make UDS calls
	 * @throws ThreadSessionException
	 */
	public static ThreadSession initializePASThreadSession(long accessorCompanyId, String domainName)
			throws ThreadSessionException {
		try {
			PersistenceSessionManager.createThreadSession();
			PersistenceSessionManager.currentThreadSession().openSession();
			ThreadSessionManager.currentUserSession().setAccessorCompanyId(accessorCompanyId);
			ThreadSessionManager.currentUserSession()
					.setAccessorCompanyDomainName(domainName);
			Locale locale = new Builder().setLanguage(LANGUAGE_CODE)
					.setScript(LATN).setRegion(COUNTRY_CODE).build();
			ThreadSessionManager.currentUserSession().setUserLocale(locale);
		} catch (ThreadSessionException e) {
			throw e;
		}
		
		return PersistenceSessionManager.currentThreadSession();
	}

	/**
	 * Release PAS thread session
	 */
	public static void releasePASThreadSession() {
		ThreadSessionManager.releaseResources();
	}
	
	
	public static String fetchPASSecurityToken() throws HMTPException{
		
		String token = null;
		
		List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJaxbJsonProvider());
		try{
			WebClient client = WebClient.create(SECURITY_TOKEN_END_SERVICE_URL, providers);
	        client = client.accept("application/json").type(MediaType.APPLICATION_FORM_URLENCODED);
	        token = client.invoke(HttpMethod.POST, queryParametersForSecurityToken(),String.class);
		}catch(Exception e){
			e.printStackTrace();
		}
        return token;
		
	}
	
	
	private static String queryParametersForSecurityToken() {
		//TODO Need to move values to either property or yaml file
		StringBuffer buffer = new StringBuffer(USER_NAME);
		return buffer.append(EQUALS).append("admin").append(AND).append(PASS_WORD).
				append(EQUALS).append("fusion@123").append(AND)
				.append(DOMAIN).append(EQUALS).append("fusion").toString();
	}
	}

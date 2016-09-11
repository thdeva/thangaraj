package testcases;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;










import util.SampleIntegrationTestCasesUtil;

import com.hcl.hmtp.application.client.service.DataAccessPolicyTestService;
import com.hcl.hmtp.common.client.beans.Filter;
import com.hcl.hmtp.common.client.beans.PaginatedBeanHolder;
import com.hcl.hmtp.common.client.beans.RelationMetadata;
import com.hcl.hmtp.common.client.exceptions.HMTPException;
import com.hcl.hmtp.common.server.PersistenceSessionManager;
import com.hcl.hmtp.common.server.ThreadSessionManager;
import com.hcl.hmtp.common.server.constants.PlatformConstants;
import com.hcl.hmtp.common.server.dao.MasterDAO;
import com.hcl.hmtp.common.server.exceptions.ThreadSessionException;
import com.hcl.hmtp.common.server.logger.HMTPLoggerFactory;
import com.hcl.hmtp.common.server.util.PersistenceInitUtil;
import com.hcl.hmtp.common.testcases.util.CommonIntegrationTestCasesUtil;
import com.hcl.hmtp.core.dataservices.client.service.MultiTenantJPAService;
import com.hcl.hmtp.core.dataservices.client.service.MultiTenantUnifiedDataService;
import com.hcl.hmtp.core.dataservices.client.service.UnifiedDataService;
import com.hcl.hmtp.security.client.beans.PermissionBean;
import com.hcl.hmtp.security.client.beans.RoleBean;
import com.hcl.hmtp.security.client.service.MultiTenantRoleAndPermissionService;
import com.raja.pas.beans.StudentBean;
import com.raja.pas.beans.StudentMarksBean;
import com.training.passession1.ApplicationBoot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationBoot.class,loader = SpringApplicationContextLoader.class)
public class SampleIntegrationTest implements ApplicationContextAware {

	@Value("${pas.security_remote_url}") 
    private String securityUrl;
	private ApplicationContext applicationContext;
	@Autowired
	private DataAccessPolicyTestService dataAccessPolicyTestService;
	
	@Autowired 
	private MultiTenantUnifiedDataService uds;
	@Resource 
	private MasterDAO masterDAO;
	    
	@Resource 
	private MultiTenantJPAService multiTenantJpaService;
	
	@Autowired @Qualifier("anonymousMultiTenantRoleAndPermissionService") 
	private MultiTenantRoleAndPermissionService unAuthenticatedRoleAndPermissionService;
	
	@Before
	public void setup() throws Exception{
		
		//System.out.println("Test111111111111111");
		try {
		
		PersistenceInitUtil.initialize(applicationContext);
		CommonIntegrationTestCasesUtil.initializePASContextHolder(applicationContext);
		CommonIntegrationTestCasesUtil.initializePASThreadSession(1,"fusion");
		//CommonIntegrationTestCasesUtil.fetchPASSecurityToken("admin", "fusion@123", "heliosit");
		String securityToken = SampleIntegrationTestCasesUtil.fetchPASSecurityToken();
		logTheMessage("login authentication security token::"+securityToken);
		
		ThreadSessionManager.currentUserSession().setObject(PlatformConstants.brownstoneauthcookie.toString(), securityToken);
		
		
		}
		 catch (ThreadSessionException e) {
			 TestCase.fail();
			throw e;
		}
	}

	
	@After
	public void releaseResources(){
		SampleIntegrationTestCasesUtil.releasePASThreadSession();
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	private void logTheMessage(String info) {
  		HMTPLoggerFactory.getLogger(this.getClass().getName()).info(
  				info);
  	}
	
	
	private void authenticate() throws Exception{
		Set<RoleBean> roles = unAuthenticatedRoleAndPermissionService.fetchRoles("admin", "fusion");
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (RoleBean roleBean: roles) {
            Set<PermissionBean> permissions = roleBean.getPermissions();
            for (PermissionBean permissionBean: permissions) {
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + permissionBean.getName());
                grantedAuthorities.add(authority);
            }
        }
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken("admin", "", grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(token);
	}
	
	
	
	
	
@Test
	
	public void testUdsCreate() throws HMTPException {
        
		logTheMessage("Executing the UDS create test case");
		
        try {
        	
        	PersistenceSessionManager.currentThreadSession().beginTransaction();
        	RelationMetadata rmd=new RelationMetadata();
        	/*rmd.addRelation(StudentBean.STUDENT_COMPANY);
        	rmd.addRelation(StudentBean.STUDENT_MARKS);*/
        	uds.createEntity(createStudentBean(),1);
        	PersistenceSessionManager.currentThreadSession().commitSession();
        } catch (final Exception e) {
        	e.printStackTrace();
        	TestCase.fail();
        	
            throw new HMTPException(e);
        }
    }
public static StudentBean createStudentBean() {
	
    StudentBean StudentBean = new StudentBean();
    StudentBean.setName("Rajaram");
    StudentBean.setBatch("2008-2012");;

    StudentMarksBean addressBean = new StudentMarksBean();
    addressBean.setSubject("English");; 
    addressBean.setMarks(80);
    
    StudentMarksBean addressBean1 = new StudentMarksBean();
    addressBean.setSubject("English");; 
    addressBean.setMarks(80);
    StudentBean.addStudentMarks(addressBean);
    StudentBean.addStudentMarks(addressBean1);
    return StudentBean;

}


@Test
public void testUdsDelete() throws HMTPException {
    
	logTheMessage("Executing the UDS delete test case");
	
    try {
    	
    	PersistenceSessionManager.currentThreadSession().beginTransaction();
    	RelationMetadata rmd=new RelationMetadata();
    	rmd.addRelation(StudentBean.STUDENT_COMPANY);
    	rmd.addRelation(StudentBean.STUDENT_MARKS);
    	uds.deleteEntity(StudentBean.class,3);
    	PersistenceSessionManager.currentThreadSession().commitSession();
    } catch (final Exception e) {
    	e.printStackTrace();
    	TestCase.fail();
    	
        throw new HMTPException(e);
    }
}

@Test
public void testUdsUpdate() throws HMTPException {
    
	logTheMessage("Executing the UDS delete test case");
	
    try {
    	
    	PersistenceSessionManager.currentThreadSession().beginTransaction();
    	RelationMetadata rmd=new RelationMetadata();
    	rmd.addRelation(StudentBean.STUDENT_COMPANY);
    	rmd.addRelation(StudentBean.STUDENT_MARKS);
    	//StudentBean sb1=getStudentBean();
    	StudentBean sb=new StudentBean();
    	sb.setId(1);
    	sb.setBatch("2010-2014");
    	sb.setName("RR");
    	uds.updateEntity(sb);
    	PersistenceSessionManager.currentThreadSession().commitSession();
    } catch (final Exception e) {
    	e.printStackTrace();
    	TestCase.fail();
    	
        throw new HMTPException(e);
    }
}
@Test
@Ignore
public void fetchEntity(){
	try{
	PersistenceSessionManager.currentThreadSession().beginTransaction();
	RelationMetadata rmd=new RelationMetadata();
	rmd.addRelation(StudentBean.STUDENT_COMPANY);
	rmd.addRelation(StudentBean.STUDENT_MARKS);
	Filter f=new Filter("id",new Long("15"),Filter.OP_EQ,Filter.TYPE_LONG);
	PaginatedBeanHolder sb= uds.fetchEntities(StudentBean.class, rmd, f, null,1);
	StudentBean sb1=(StudentBean) sb.getBeans().get(0);
	PersistenceSessionManager.currentThreadSession().commitSession();
	}catch(Exception e){
		TestCase.fail();
	}
}
private StudentBean getStudentBean() {
	// TODO Auto-generated method stub
	try{
		PersistenceSessionManager.currentThreadSession().beginTransaction();
		RelationMetadata rmd=new RelationMetadata();
    	rmd.addRelation(StudentBean.STUDENT_COMPANY);
    	rmd.addRelation(StudentBean.STUDENT_MARKS);
    	Filter f=new Filter("id",new Long("1"),Filter.OP_EQ,Filter.TYPE_LONG);
    	PaginatedBeanHolder sb= uds.fetchEntities(StudentBean.class, rmd, f, null,1);
    	StudentBean sb1=(StudentBean) sb.getBeans().get(0);
    	PersistenceSessionManager.currentThreadSession().commitSession();
    	return sb1;
	}catch(Exception e){
		return null;
	}
}
}
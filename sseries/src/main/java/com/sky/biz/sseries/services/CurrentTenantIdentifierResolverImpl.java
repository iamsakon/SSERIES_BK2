package com.sky.biz.sseries.services;

import javax.servlet.http.HttpSession;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver{
	
	final String KEY_TENANTID_SESSION = "";
	
	final String DEFAULT_TENANTID = "";
	
	@Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = resolveTenantByHttpSession();
        //logger.trace("Tenant resolved: " + tenant);
        return tenant;
    }
    /**
     * Get tenantId in the session attribute KEY_TENANTID_SESSION
     * @return TenantId on KEY_TENANTID_SESSION
     */
    public String resolveTenantByHttpSession()
    {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //If session attribute exists returns tenantId saved on the session
        if(attr != null){
            HttpSession session = attr.getRequest().getSession(false); // true == allow create
            if(session != null){
                String tenant = (String) session.getAttribute(KEY_TENANTID_SESSION);
                if(tenant != null){
                    return tenant;
                }
            }
        }
        //otherwise return default tenant
        //logger.trace("Tenant resolved in session is: " + DEFAULT_TENANTID);
        return DEFAULT_TENANTID;
    }
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}

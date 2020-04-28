package com.mt.rideshare.service.impl;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mt.rideshare.service.LdapAuthenticationService;

import io.swagger.rideshare.model.User;

@Service
public class LdapAuthenticationServiceImpl implements  LdapAuthenticationService{

	private static final String COM_SUN_JNDI_LDAP_LDAP_CTX_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";


	private static final Logger logger = LoggerFactory.getLogger(LdapAuthenticationServiceImpl.class);

	
	@Value("${java.naming.provider.url}")
	private String ldapUrl;
	@Value("${java.naming.security.principal}")
	private String svcId;
	@Value("${java.naming.security.credentials}")
	private String svcPassword;
	@Value("${java.naming.security.protocol}")
	private String ssl;
	@Value("${base}")
	private String base;


	public boolean isAutheneticated(User user) {

		DirContext dirCtx = null;
		try {
			// String base = "OU=DL IT,OU=User
			// Accounts,dc=delta,dc=rl,dc=delta,dc=com";
			// String base = "OU=User Accounts,dc=delta,dc=rl,dc=delta,dc=com";
			InitialLdapContext ctx = null;
			StringBuffer name = new StringBuffer("");
			Hashtable<String, String> env = new Hashtable<String, String>();
			String distinguishedName = null;
			Attributes attr;

			env.put("java.naming.provider.url", ldapUrl);
			env.put("java.naming.security.principal", svcId);
			env.put("java.naming.security.credentials", svcPassword);
			// env.put("java.naming.security.protocol", ssl);
			env.put("java.naming.security.authentication", "simple");
			env.put("java.naming.factory.initial", COM_SUN_JNDI_LDAP_LDAP_CTX_FACTORY);
			dirCtx = initialLDAPContext(env);
			// Make LDAP connection
			ctx = new InitialLdapContext(env, null);
			// System.out.println(("ctx="+ctx);
			// String[] attributeFilter = { "memberOf" };
			SearchControls ctls = new SearchControls();
			// ctls.setReturningAttributes(attributeFilter);
			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String userId = user.getUsername();
			// the production passport returned pprId instead of user id
			if (user.getUsername() != null && user.getUsername().length() > 6) {
				userId=(user.getUsername().substring(1, 7));
			}
			NamingEnumeration<SearchResult> entries = ctx.search(base, "(cn=" + userId + ")", ctls);
			logger.debug("entries=" + entries + " for loginId" + userId + " hasMoreElements"
					+ entries.hasMoreElements() + " hasMore=" + entries.hasMore());
			if (entries.hasMoreElements() && entries.hasMore()) {
				while (entries.hasMore()) {

					SearchResult entryResult = (SearchResult) entries.next();

					distinguishedName = entryResult.getNameInNamespace();

					logger.debug("distinguishedName" + distinguishedName);
					attr = entryResult.getAttributes();
					// System.out.println(("attr="+attr+" "+ attr.toString());
					if (attr.get("givenName") != null) {
						user.setFirstName(attr.get("givenName").get().toString());
					}
					if (attr.get("sn") != null) {
						user.setLastName(attr.get("sn").get().toString());
					}
					user.setUsername(userId);
					break;
				}
				// attempt another authentication, now with the user
				Properties authEnv = new Properties();
				authEnv.put(Context.INITIAL_CONTEXT_FACTORY, COM_SUN_JNDI_LDAP_LDAP_CTX_FACTORY);
				authEnv.put(Context.PROVIDER_URL, ldapUrl);
				authEnv.put(Context.SECURITY_PRINCIPAL, distinguishedName);
				authEnv.put(Context.SECURITY_CREDENTIALS, user.getSecretKey());
				new InitialDirContext(authEnv);

				logger.info("authentication sucessful" + distinguishedName);

			} else {
				throw new RuntimeException("UserName or Password Wrong");
			}
			entries.close();

		} catch (Exception e) {

			String message = e.getMessage();
			if (e instanceof javax.naming.AuthenticationException) {
				logger.error(e.getMessage(), e);
				message = "UserName or Password Wrong";

			}
			throw new RuntimeException(message);

		} finally

		{
			if (dirCtx != null) {
				try {
					dirCtx.close();
				} catch (Exception e) {
					//throw new RuntimeException(e);
				}
			}

		}
		return true;

	}

	private DirContext initialLDAPContext(Hashtable env) throws NamingException {
		DirContext dirCtx = null;

		try {
			env.put("java.naming.factory.initial", COM_SUN_JNDI_LDAP_LDAP_CTX_FACTORY);
			// env.put("java.naming.security.protocol", this.ssl);
			env.put("java.naming.security.authentication", "Simple");
			env.put("java.naming.provider.url", this.ldapUrl);
			env.put("java.naming.security.principal", this.svcId);
			env.put("java.naming.security.credentials", this.svcPassword);
			dirCtx = new InitialDirContext(env);
		} catch (Exception e) {

			throw new RuntimeException(e);

		}
		return dirCtx;
	}

}

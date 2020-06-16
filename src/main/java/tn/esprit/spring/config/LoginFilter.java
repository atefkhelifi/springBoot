package tn.esprit.spring.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tn.esprit.spring.controller.HomeController;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}}

	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}*/

	/*@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		HomeController employeController = (HomeController) httpServletRequest.getSession()
				.getAttribute("employeController");
		if (employeController.getAuthenticatedUser()==null || !employeController.getLoggedIn()) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/xhtml/login.xhtml");
		}
	}
*/
	/*Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	Boolean log=false;
	@Override
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain FilterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest= (HttpServletRequest) ServletRequest;
		HttpServletResponse httpServletResponse= (HttpServletResponse) ServletResponse;

		//DispoController dispo= (DispoController) httpServletRequest.getSession().getAttribute("dispocontroller");
		HomeController employeController= (HomeController) httpServletRequest.getSession().getAttribute("employeController");
		
		try {
			logger.info(employeController.getLoggedIn().toString());
			log=employeController.getLoggedIn();
		}
		catch(NullPointerException n) {
			logger.info("THERE IS NO USER CONNECTED");
		}

		if(log.equals(false)) {
			//FilterChain.doFilter(ServletRequest, ServletResponse);
			//httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/loginpage.jsf");
			httpServletResponse.sendRedirect("/xhtml/login.xhtml");
		}
		else{
			FilterChain.doFilter(ServletRequest, ServletResponse);
		}
		}*/



package com.hand.myWeb.filter;

import com.hand.myWeb.common.Constants;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter{

	private String endcoding=Constants.ENCODING;
	
	public void destroy() {}

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding(endcoding);//
		response.setCharacterEncoding(endcoding);//
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {		
		this.endcoding = filterConfig.getInitParameter(Constants.ENCODING_PARAM_NAME);
	}
}

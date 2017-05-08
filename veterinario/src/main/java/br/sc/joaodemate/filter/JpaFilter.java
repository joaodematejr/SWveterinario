package br.sc.joaodemate.filter;

import javax.servlet.annotation.WebFilter;

import br.sc.joaodemate.commons.JpaUtils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(servletNames = "Faces Servlet")
public class JpaFilter implements Filter {

	@Override
	public void destroy() {
		JpaUtils.destroy();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		EntityManager entityManager = JpaUtils.EntityManager(request);
		entityManager.getTransaction().begin();
		filterChain.doFilter(request, response);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		JpaUtils.init();
	}

}

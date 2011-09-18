/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package showdown.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Login filter.
 * @author Ben Zoller
 */
public class LoginFilter implements Filter {

    protected FilterConfig filterConfig = null;

    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }
}

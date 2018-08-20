package sl314.web;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

public class PerformanceFilter implements Filter {

  private FilterConfig config;
  private String logPrefix;

  public void init(FilterConfig config)
    throws ServletException {
    this.config = config;
    logPrefix = config.getInitParameter("Log Entry Prefix");
  }

  public void doFilter(ServletRequest request,
    ServletResponse response, FilterChain chain)
    throws ServletException, IOException {

    long begin = System.currentTimeMillis();
    chain.doFilter(request, response);
    long end = System.currentTimeMillis();

    StringBuffer logMessage = new StringBuffer();
    if (request instanceof HttpServletRequest) {
      logMessage = ((HttpServletRequest)request).getRequestURL();
    }
    logMessage.append(": ");
    logMessage.append(end - begin);
    logMessage.append(" ms");

    if(logPrefix != null) {
      logMessage.insert(0,logPrefix);
    }

    config.getServletContext().log(logMessage.toString());
  }

  public void destroy() {
    config = null;
    logPrefix = null;
  }

}

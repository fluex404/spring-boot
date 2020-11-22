package com.fluex404.zuulserver.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class CustomZuulFilter extends ZuulFilter {
 
    private static final Logger logger = LoggerFactory.getLogger(CustomZuulFilter.class);


    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
//        String uri = context.getRequest().getRequestURI();

        HttpServletRequest request = context.getRequest();

        String authorization = request.getHeader("Authorization");
        boolean allowed = false;
        if(authorization != null && !authorization.isEmpty()) {

            allowed = true;


        }

        String filter = request.getParameter("filter");
        if(filter != null) {
            allowed = false;
        }

        if(!allowed) {
            context.setResponseStatusCode(400);
            context.setResponseBody("access denied");
            context.setSendZuulResponse(false);
        }

        return null;
    }

	@Override
	public boolean shouldFilter() {
        // logger.warn("SHOULD");
        RequestContext context = RequestContext.getCurrentContext();

        /**
         * kalau true masuk ke run()
         */
        return true;
	}

	@Override
	public String filterType() {
		// logger.warn("TYPE");
		// pre, post, routing, error
		return "route";
	}

	@Override
	public int filterOrder() {
		// logger.warn("ORDER");
		return 0;
    }


}
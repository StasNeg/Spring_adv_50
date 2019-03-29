package beans.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class RequestObjectAttributeFilter implements Filter {

    /**
     *
     */
    public void init(FilterConfig paramFilterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req,
                         ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        req.setAttribute("RequestObject", req);

        filterChain.doFilter(req, res);
    }

    public void destroy() {

    }

}
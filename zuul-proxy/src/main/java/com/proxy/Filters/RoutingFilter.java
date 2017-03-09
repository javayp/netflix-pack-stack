package com.proxy.Filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class RoutingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
       /* System.out.println("Current Context "+RequestContext.getCurrentContext());

        System.out.println("***ROUTE HOST"+ctx.getRouteHost());
        System.out.println("***ZuulRespone"+ctx.sendZuulResponse());
        System.out.println("***Service ID"+ctx.get("serviceId"));
        System.out.println("***Request Query Parms***"+ctx.getRequestQueryParams());
        System.out.println("Response and Response Body"+ctx.getResponse()+"   "+ctx.getResponseBody());
        System.out.println("Filter Execution Summary"+ctx.getFilterExecutionSummary());*/

        //System.out.println("ctx.getRouteHost() "+ctx.getRouteHost().getPath());
        System.out.println("ctx.get(\"serviceId\") "+ctx.get("serviceId"));
        System.out.println("ctx.sendZuulResponse() "+ctx.sendZuulResponse());

        return (ctx.getRouteHost() == null && ctx.get("serviceId") != null && ctx.sendZuulResponse());
    }

    @Override
    public Object run() {
        System.out.println("**********Running!!!!");
        return null;
    }
}
package com.example.filter;
/**
 * Class name: ${NAME}
 * Package name: ${PACKAGE_NAME}
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/8/1-15:35
 */


import com.example.utils.JdbcUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "TransactionFilter", value = "/*")
public class TransactionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {


        try {
            chain.doFilter(request, response);

            JdbcUtils.commitAndClose(); // 提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose(); // 回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

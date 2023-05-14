package com.ontop.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
public class PaginationUtility {
    public static PageRequest getPageRequest(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return PageRequest.of(pageNumber, pageSize, sortDirection, sortField);
    }
}

package com.jxzj.external.data.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BlogRespository extends ElasticsearchRepository<BlogModel, String> {

}

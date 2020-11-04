package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Provider;

import java.util.List;

public interface ProviderMapper {

    List<Provider> getproviders (Provider provider);
    Provider getProvider (Integer pid);
    int addProvider(Provider provider);
    int updateProvider(Provider provider);
    int deletProviderByPid(Integer pid);

}

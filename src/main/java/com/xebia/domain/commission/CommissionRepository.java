package com.xebia.domain.commission;

public interface CommissionRepository {

    void save(Commission commission);

    Commission findOne(Long id);

}

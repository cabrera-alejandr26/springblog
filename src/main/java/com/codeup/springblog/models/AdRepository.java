package com.codeup.springblog.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository  extends JpaRepository <Ad, Long> {
    @Query("from Ad a where a.id like ?1")
        Ad findById(long id);
        Ad findFirstByTitle(String title);

        @Query("from Ad a where a.title like %:term% limit")
                Ad findFirstByTitle(String term);
}

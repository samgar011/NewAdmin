package com.example.newadmin.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Integer> {
    public Long countById(Integer id);

//    @Query(value = "select * from adminusers a where a.first_name like %:keyword% ", nativeQuery = true)
//    <List> User findbyKeyWord(@Param("keyword") String keyword);


}

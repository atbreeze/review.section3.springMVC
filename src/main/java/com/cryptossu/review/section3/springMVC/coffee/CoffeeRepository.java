package com.cryptossu.review.section3.springMVC.coffee;

import com.cryptossu.review.section3.springMVC.coffee.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    @Query("SELECT * FROM COFFEE WHERE COFFEE_ID = :coffeeId")
    Optional<Coffee> findById(Long coffeeId);

    @Query("SELECT * FROM COFFEE WHERE COFFEE_ID = :coffeeId")
    Optional<Coffee> findByCoffee(Long coffeeId);

    //쿼리문을 직접 사용해서 복잡한 쿼리문을 작성할 수 있다.
//    @Query("SELECT * FROM COFFEE WHERE COFFEE_ID = :coffeeId")
//    Optional<Coffee> findByCoffee(Long coffeeId);



}

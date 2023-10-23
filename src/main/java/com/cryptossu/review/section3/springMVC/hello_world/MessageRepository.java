package com.cryptossu.review.section3.springMVC.hello_world;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}

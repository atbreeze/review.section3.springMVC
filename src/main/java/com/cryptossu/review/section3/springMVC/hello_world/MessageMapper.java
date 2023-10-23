package com.cryptossu.review.section3.springMVC.hello_world;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message messageDtoToMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageResponseDro(Message message);
}

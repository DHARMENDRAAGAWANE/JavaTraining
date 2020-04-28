package com.mt.daretotry.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mt.daretotry.converter.factory.ConverterFactory;
import com.mt.daretotry.dto.UserDTO;
import com.mt.daretotry.entity.User;

@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
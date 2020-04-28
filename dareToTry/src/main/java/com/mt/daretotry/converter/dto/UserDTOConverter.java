package com.mt.daretotry.converter.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.mt.daretotry.dto.UserDTO;
import com.mt.daretotry.entity.Authority;
import com.mt.daretotry.entity.User;

public class UserDTOConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(final UserDTO dto) {
        final User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAccountNonExpired(false);
        user.setCredentialsNonExpired(false);
        user.setEnabled(true);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.ROLE_USER);
        user.setAuthorities(authorities);
        return user;
    }
}

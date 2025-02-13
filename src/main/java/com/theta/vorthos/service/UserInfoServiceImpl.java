package com.theta.vorthos.service;

import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.mapper.DtoToEntity;
import com.theta.vorthos.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final DtoToEntity dtoToEntity;

    @Override
    public boolean signup(UserDto userDto) {
        try{
            userInfoRepository.save(dtoToEntity.toUserInfo(userDto));
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}

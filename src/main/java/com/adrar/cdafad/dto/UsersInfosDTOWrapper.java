package com.adrar.cdafad.dto;
import com.adrar.cdafad.entity.Category;
import com.adrar.cdafad.entity.Users;
import com.adrar.cdafad.dto.UsersInfosDTO;
public class UsersInfosDTOWrapper {
    public static UsersInfosDTO wrapUsersInfosToUsersInfosDTO(Users users)
    {
        return new UsersInfosDTO(users.getEmail(), users.getFirstname(), users.getLastname());
    }
}

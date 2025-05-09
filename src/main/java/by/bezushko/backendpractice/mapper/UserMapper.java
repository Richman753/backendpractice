package by.bezushko.backendpractice.mapper;

import by.bezushko.backendpractice.dto.UserDto;
import by.bezushko.backendpractice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    void updateUser(User source, @MappingTarget User target);
    User toObject(UserDto userDto);
    UserDto toDto(User user);
}

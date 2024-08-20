package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.NotificationDTO;
import com.momsdeli.online.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(source = "user.username", target = "user")
    NotificationDTO toDTO(Notification notification);

    @Mapping(source = "user", target = "user.username")
    Notification toEntity(NotificationDTO notificationDTO);

    List<NotificationDTO> toDTOs(List<Notification> notifications);

    List<Notification> toEntities(List<NotificationDTO> notificationDTOs);
}

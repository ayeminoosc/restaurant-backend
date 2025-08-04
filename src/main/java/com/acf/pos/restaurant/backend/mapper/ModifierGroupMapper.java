package com.acf.pos.restaurant.backend.mapper;

import com.acf.pos.restaurant.backend.dto.ModifierGroupCreateRequest;
import com.acf.pos.restaurant.backend.dto.ModifierGroupResponse;
import com.acf.pos.restaurant.backend.dto.ModifierGroupUpdateRequest;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ModifierGroupMapper {

    private final ModifierMapper modifierMapper;

    public ModifierGroupMapper(ModifierMapper modifierMapper) {
        this.modifierMapper = modifierMapper;
    }

    public ModifierGroup toEntity(ModifierGroupCreateRequest request) {
        if (request == null) {
            return null;
        }

        ModifierGroup modifierGroup = new ModifierGroup();
        modifierGroup.setName(request.getName());
        modifierGroup.setBilingualName(request.getBilingualName());
        modifierGroup.setMinSelection(request.getMinSelection() != null ? request.getMinSelection() : 0);
        modifierGroup.setMaxSelection(request.getMaxSelection() != null ? request.getMaxSelection() : 1);
        modifierGroup.setMultipleSelection(request.getMultipleSelection() != null ? request.getMultipleSelection() : false);
        modifierGroup.setRequired(request.getRequired() != null ? request.getRequired() : false);
        modifierGroup.setDisplayOrder(request.getDisplayOrder());
        modifierGroup.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
        modifierGroup.setColorCode(request.getColorCode());

        return modifierGroup;
    }

    public void updateEntity(ModifierGroup modifierGroup, ModifierGroupUpdateRequest request) {
        if (request == null || modifierGroup == null) {
            return;
        }

        if (request.getName() != null) {
            modifierGroup.setName(request.getName());
        }
        if (request.getBilingualName() != null) {
            modifierGroup.setBilingualName(request.getBilingualName());
        }
        if (request.getMinSelection() != null) {
            modifierGroup.setMinSelection(request.getMinSelection());
        }
        if (request.getMaxSelection() != null) {
            modifierGroup.setMaxSelection(request.getMaxSelection());
        }
        if (request.getMultipleSelection() != null) {
            modifierGroup.setMultipleSelection(request.getMultipleSelection());
        }
        if (request.getRequired() != null) {
            modifierGroup.setRequired(request.getRequired());
        }
        if (request.getDisplayOrder() != null) {
            modifierGroup.setDisplayOrder(request.getDisplayOrder());
        }
        if (request.getIsActive() != null) {
            modifierGroup.setIsActive(request.getIsActive());
        }
        if (request.getColorCode() != null) {
            modifierGroup.setColorCode(request.getColorCode());
        }
    }

    public ModifierGroupResponse toResponse(ModifierGroup modifierGroup) {
        if (modifierGroup == null) {
            return null;
        }

        ModifierGroupResponse response = new ModifierGroupResponse();
        response.setId(modifierGroup.getId());
        response.setName(modifierGroup.getName());
        response.setBilingualName(modifierGroup.getBilingualName());
        response.setMinSelection(modifierGroup.getMinSelection());
        response.setMaxSelection(modifierGroup.getMaxSelection());
        response.setMultipleSelection(modifierGroup.isMultipleSelection());
        response.setRequired(modifierGroup.isRequired());
        response.setDisplayOrder(modifierGroup.getDisplayOrder());
        response.setIsActive(modifierGroup.getIsActive());
        response.setColorCode(modifierGroup.getColorCode());

        // Convert modifiers if available
        if (modifierGroup.getModifiers() != null) {
            response.setModifiers(modifierMapper.toResponseList(
                new ArrayList<>(modifierGroup.getModifiers())
            ));
        }

        if (modifierGroup.getCreatedAt() != null) {
            response.setCreatedAt(LocalDateTime.ofInstant(
                modifierGroup.getCreatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }
        
        if (modifierGroup.getUpdatedAt() != null) {
            response.setUpdatedAt(LocalDateTime.ofInstant(
                modifierGroup.getUpdatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }

        return response;
    }

    public List<ModifierGroupResponse> toResponseList(List<ModifierGroup> modifierGroups) {
        if (modifierGroups == null) {
            return null;
        }
        
        List<ModifierGroupResponse> responses = new ArrayList<>();
        for (ModifierGroup modifierGroup : modifierGroups) {
            responses.add(toResponse(modifierGroup));
        }
        return responses;
    }
}
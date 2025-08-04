package com.acf.pos.restaurant.backend.mapper;

import com.acf.pos.restaurant.backend.dto.ModifierCreateRequest;
import com.acf.pos.restaurant.backend.dto.ModifierResponse;
import com.acf.pos.restaurant.backend.dto.ModifierUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Modifier;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ModifierMapper {

    private final PrefixMapper prefixMapper;

    public ModifierMapper(PrefixMapper prefixMapper) {
        this.prefixMapper = prefixMapper;
    }

    public Modifier toEntity(ModifierCreateRequest request) {
        if (request == null) {
            return null;
        }

        Modifier modifier = new Modifier();
        
        ModifierGroup modifierGroup = new ModifierGroup();
        modifierGroup.setId(request.getModifierGroupId());
        modifier.setModifierGroup(modifierGroup);

        modifier.setName(request.getName());
        modifier.setBilingualName(request.getBilingualName());
        modifier.setPrice(request.getPrice() != null ? request.getPrice() : 0.0);
        modifier.setDisplayOrder(request.getDisplayOrder());
        modifier.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
        modifier.setIsDefault(request.getIsDefault() != null ? request.getIsDefault() : false);

        return modifier;
    }

    public void updateEntity(Modifier modifier, ModifierUpdateRequest request) {
        if (request == null || modifier == null) {
            return;
        }

        if (request.getName() != null) {
            modifier.setName(request.getName());
        }
        if (request.getBilingualName() != null) {
            modifier.setBilingualName(request.getBilingualName());
        }
        if (request.getPrice() != null) {
            modifier.setPrice(request.getPrice());
        }
        if (request.getDisplayOrder() != null) {
            modifier.setDisplayOrder(request.getDisplayOrder());
        }
        if (request.getIsActive() != null) {
            modifier.setIsActive(request.getIsActive());
        }
        if (request.getIsDefault() != null) {
            modifier.setIsDefault(request.getIsDefault());
        }
    }

    public ModifierResponse toResponse(Modifier modifier) {
        if (modifier == null) {
            return null;
        }

        ModifierResponse response = new ModifierResponse();
        response.setId(modifier.getId());
        response.setModifierGroupId(modifier.getModifierGroup() != null ? modifier.getModifierGroup().getId() : null);
        response.setName(modifier.getName());
        response.setBilingualName(modifier.getBilingualName());
        response.setPrice(modifier.getPrice());
        response.setDisplayOrder(modifier.getDisplayOrder());
        response.setIsActive(modifier.getIsActive());
        response.setIsDefault(modifier.getIsDefault());

        // Convert prefixes if available (through ModifierPrefix junction)
        // This would need additional logic to fetch prefixes through the junction table

        if (modifier.getCreatedAt() != null) {
            response.setCreatedAt(LocalDateTime.ofInstant(
                modifier.getCreatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }
        
        if (modifier.getUpdatedAt() != null) {
            response.setUpdatedAt(LocalDateTime.ofInstant(
                modifier.getUpdatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }

        return response;
    }

    public List<ModifierResponse> toResponseList(List<Modifier> modifiers) {
        if (modifiers == null) {
            return null;
        }
        
        List<ModifierResponse> responses = new ArrayList<>();
        for (Modifier modifier : modifiers) {
            responses.add(toResponse(modifier));
        }
        return responses;
    }
}
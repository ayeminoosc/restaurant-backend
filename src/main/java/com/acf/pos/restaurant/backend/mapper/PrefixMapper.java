package com.acf.pos.restaurant.backend.mapper;

import com.acf.pos.restaurant.backend.dto.PrefixCreateRequest;
import com.acf.pos.restaurant.backend.dto.PrefixResponse;
import com.acf.pos.restaurant.backend.dto.PrefixUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Prefix;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PrefixMapper {

    public Prefix toEntity(PrefixCreateRequest request) {
        if (request == null) {
            return null;
        }

        Prefix prefix = new Prefix();
        prefix.setName(request.getName());
        prefix.setBilingualName(request.getBilingualName());
        prefix.setDisplayOrder(request.getDisplayOrder());
        prefix.setColorCode(request.getColorCode());

        return prefix;
    }

    public void updateEntity(Prefix prefix, PrefixUpdateRequest request) {
        if (request == null || prefix == null) {
            return;
        }

        if (request.getName() != null) {
            prefix.setName(request.getName());
        }
        if (request.getBilingualName() != null) {
            prefix.setBilingualName(request.getBilingualName());
        }
        if (request.getDisplayOrder() != null) {
            prefix.setDisplayOrder(request.getDisplayOrder());
        }
        if (request.getColorCode() != null) {
            prefix.setColorCode(request.getColorCode());
        }
    }

    public PrefixResponse toResponse(Prefix prefix) {
        if (prefix == null) {
            return null;
        }

        PrefixResponse response = new PrefixResponse();
        response.setId(prefix.getId());
        response.setName(prefix.getName());
        response.setBilingualName(prefix.getBilingualName());
        response.setDisplayOrder(prefix.getDisplayOrder());
        response.setColorCode(prefix.getColorCode());

        if (prefix.getCreatedAt() != null) {
            response.setCreatedAt(LocalDateTime.ofInstant(
                prefix.getCreatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }
        
        if (prefix.getUpdatedAt() != null) {
            response.setUpdatedAt(LocalDateTime.ofInstant(
                prefix.getUpdatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }

        return response;
    }

    public List<PrefixResponse> toResponseList(List<Prefix> prefixes) {
        if (prefixes == null) {
            return null;
        }
        
        List<PrefixResponse> responses = new ArrayList<>();
        for (Prefix prefix : prefixes) {
            responses.add(toResponse(prefix));
        }
        return responses;
    }
}
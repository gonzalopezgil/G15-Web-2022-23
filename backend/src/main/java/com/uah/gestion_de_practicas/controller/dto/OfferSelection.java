package com.uah.gestion_de_practicas.controller.dto;

import com.uah.gestion_de_practicas.model.Request;

import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO to manage the offer selection data.
 */
@Data
@EqualsAndHashCode
@ToString
public class OfferSelection {
    private Long offerId;
    private int preference;

    public OfferSelection(Long offerId, int preference) {
        this.offerId = offerId;
        this.preference = preference;
    }

    public OfferSelection() {
    }

    public static OfferSelection fromRequest(Request request) {
        return new OfferSelection(request.getOffer().getId(), request.getPreference());
    }

    public static List<OfferSelection> fromRequests(List<Request> requests) {
        return requests.stream().map(OfferSelection::fromRequest).collect(Collectors.toList());
    }
}
